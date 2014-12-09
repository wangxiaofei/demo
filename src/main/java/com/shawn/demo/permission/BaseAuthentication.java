package com.shawn.demo.permission;

import com.shawn.demo.utils.Constant;
import com.shawn.demo.utils.DesEncrypter;

public class BaseAuthentication {
    private static final DesEncrypter desEncrypter = new DesEncrypter(Constant.WATCH_WORD);

    public static DesEncrypter getDesencrypter() {
        return desEncrypter;
    }
}
