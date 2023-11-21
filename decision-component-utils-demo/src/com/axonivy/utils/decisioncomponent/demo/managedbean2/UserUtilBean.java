package com.axonivy.utils.decisioncomponent.demo.managedbean2;

//import java.io.Serializable;
//
//import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.ManagedBean;
//
//import org.apache.commons.lang3.StringUtils;
//
//import com.ricoh.hr.core.service.IvyService;
//import com.ricoh.hr.core.util.IvyUtils;
//
//import ch.ivyteam.ivy.environment.Ivy;
//import ch.ivyteam.ivy.security.IUser;
//
//@ManagedBean
//@ApplicationScoped
//public class UserUtilBean implements Serializable {
//
//	private static final long serialVersionUID = -2531414574114333439L;
//
//	public String generateDisplayName(String userName) {
//		if (StringUtils.isBlank(userName)) {
//			return StringUtils.EMPTY;
//		}
//
//		IUser creator = Ivy.wf().getSecurityContext().users().findWithExternalLookup(userName);
//		if (creator == null) {
//			return IvyUtils.generateDisplayNameForInactiveUser(userName);
//		}
//		return UserFormatBean.format(creator.getFullName(), creator.getName());
//	}
//
//	public static String generateDisplayNameById(String securityMemberId) {
//		if (StringUtils.isBlank(securityMemberId)) {
//			return StringUtils.EMPTY;
//		}
//
//		IUser creator = IvyService.findUserById(securityMemberId);
//		if (creator == null) {
//			return IvyUtils.generateDisplayNameForInactiveUser(securityMemberId);
//		}
//		return UserFormatBean.format(creator.getFullName(), creator.getName());
//	}
//
//	public String getDisplayName(String userName) {
//		IUser iUser = IvyUtils.findUserByUserName(userName);
//		return iUser != null ? iUser.getDisplayName() : StringUtils.EMPTY;
//	}
//
//	public String getFullName(String userName) {
//		IUser iUser = IvyUtils.findUserByUserName(userName);
//		return iUser != null ? iUser.getFullName() : StringUtils.EMPTY;
//	}
//
//}
