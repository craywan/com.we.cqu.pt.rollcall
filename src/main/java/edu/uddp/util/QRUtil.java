package edu.uddp.util;

import net.glxn.qrgen.core.AbstractQRCode;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import java.io.ByteArrayOutputStream;

/**
 * url连接生成二维码
 *
 */
public class QRUtil {
    /**
     * 根据url生成二维码
     * @param url
     * @return
     */
    public static byte[] getQR(String url){
        AbstractQRCode abstractQRCode = QRCode.from(url);
        abstractQRCode.withCharset("utf-8");
        abstractQRCode.withSize(260,260);
        ByteArrayOutputStream outputStream = abstractQRCode.to(ImageType.PNG).stream();
        return  outputStream.toByteArray();
        //ByteArrayOutputStream outputStream = QRCode.
}

}
