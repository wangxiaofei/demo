package com.shawn.demo.business.Impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.shawn.demo.business.AuthorityService;
import com.shawn.demo.business.model.User;
import com.shawn.demo.utils.Constant;

@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {
    
    @Override
    public boolean canManageAccount(User user) {

        if (null != user && StringUtils.isNotBlank(user.getRole()) && Constant.ROLE_ADMIN.equals(user.getRole())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean canViewOfficialList(User user) {

        String auth = user.getAuth();
        if (StringUtils.isNotBlank(auth) && auth.indexOf(Constant.AUTHORITY_OFFICIALLIST) != -1) {
            
            return true;
        }
        
        return false;
    }


    @Override
    public boolean canCreateSingleTask(User user) {

        String auth = user.getAuth();
        if (StringUtils.isNotBlank(auth) && auth.indexOf(Constant.AUTHORITY_SINGLETASK) != -1) {
            
            return true;
        }
        
        return false;
    }


    @Override
    public boolean canCreateCrossTask(User user) {

        String auth = user.getAuth();
        if (StringUtils.isNotBlank(auth) && auth.indexOf(Constant.AUTHORITY_CROSSTASK) != -1) {
            
            return true;
        }
        
        return false;
    }
    

}
