package dongduk.cs.ssd.summerpetstore.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import dongduk.cs.ssd.summerpetstore.controller.AccountForm;
import dongduk.cs.ssd.summerpetstore.model.UserModel;
/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Component
public class AccountFormValidator implements Validator {


	public boolean supports(Class<?> clazz) {
		return UserModel.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		AccountForm accountForm = (AccountForm)obj; 
		UserModel account = accountForm.getAccount();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.username", "NAME_REQUIRED", "Name is required.");
  		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.email", "EMAIL_REQUIRED", "Email address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.phone", "PHONE_REQUIRED", "Phone number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.address", "ADDRESS_REQUIRED", "Address is required.");
		
		
		if (accountForm.isNewAccount()) {
			//account.setStatus("OK");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.userId", "USER_ID_REQUIRED", "User ID is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.password", "PASSWORD_REQUIRED", "Password is required.");
			if (account.getPassword() == null || account.getPassword().length() < 1 ) {
				errors.reject("PASSWORD_MISMATCH",
					 "Passwords did not match or were not provided. Matching passwords are required.");
			}
		}
		else if (account.getPassword() != null && account.getPassword().length() > 0) {
			
				errors.reject("PASSWORD_MISMATCH", "Passwords did not match. Matching passwords are required.");
			
		}


	}
}