package com.example.frontend.util;

import com.example.backend.controller.AddressController;
import com.example.backend.controller.BranchController;
import com.example.backend.controller.CompanyController;
import com.example.frontend.service.IndexService;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Map;

public class CDIUtil {

    private static final Map<Class<?>, String> APP = Map.of(
        AddressController.class, "backend-1.0",
        BranchController.class,  "backend-1.0",
        CompanyController.class, "backend-1.0",

        IndexService.class, "frontend-1.0"
    );

    private CDIUtil() { }

    public static <T> T resolveBean(Class<T> clazz) {
        try {
            String app = APP.get(clazz);
            String lockupName = "java:app/" + app + '/' + clazz.getSimpleName() + '!' + clazz.getName();
            return InitialContext.doLookup(lockupName);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
