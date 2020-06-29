package dongduk.cs.ssd.summerpetstore.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.summerpetstore.service.AccountFormValidator;
import dongduk.cs.ssd.summerpetstore.service.UserService;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@RequestMapping({"/spetstore/user/newAccount.do","/spetstore/user/editAccount.do"})
//@SessionAttributes("user")
public class AccountFormController { 

	@Value("user/register")
	private String formViewName;
	@Value("user/sucRegister")
	private String successViewName;
	
	@Autowired
	private UserService us;
	public void setUserService(UserService us) {
		this.us = us;
	}

	@Autowired
	private AccountFormValidator validator;
	public void setValidator(AccountFormValidator validator) {
		this.validator = validator;
	}
		
	@ModelAttribute("user")
	public AccountForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		UserSession userSession = 
			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		System.out.println("여기까지는 들어옴!");
		if (userSession != null) {	// edit an existing account
			System.out.println("usersession not null!!!!!!!!!!!!!!!!!!!!");
			return new AccountForm(
				us.getUser(userSession.getUserModel().getUsername()));
		}
		else {	// create a new account
			return new AccountForm();
		}
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		System.out.println("get!!!!!!!!!!!!!!!!!");
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			 @ModelAttribute("user") AccountForm accountForm,
			BindingResult result) throws Exception {

		validator.validate(accountForm, result);
		
		if (result.hasErrors()) { 
			
			System.out.println("에러:"+result.getAllErrors());
			return formViewName;
		}
		try {
			if (accountForm.isNewAccount()) {
				us.insertUser(accountForm.getAccount());
			}
			else {
				us.updateUser(accountForm.getAccount());
			}
		}
		catch (DataIntegrityViolationException ex) {
			result.rejectValue("account.userId", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName; 
		}
		
		UserSession userSession = new UserSession(
			us.getUser(accountForm.getAccount().getUsername()));
	/*	PagedListHolder<Product> myList = new PagedListHolder<Product>(
			petStore.getProductListByCategory(accountForm.getAccount().getFavouriteCategoryId()));
		myList.setPageSize(4);
		userSession.setMyList(myList);*/
		session.setAttribute("userSession", userSession);
		return successViewName;  
	}
}
