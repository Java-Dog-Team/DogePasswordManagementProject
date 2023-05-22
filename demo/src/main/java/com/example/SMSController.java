package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Timer;
import java.util.TimerTask;

//手機驗證碼寄送、驗證
public class SMSController {

    private HttpURLConnection sms_gw = null;
    private final String HostUsername = "say859462";
    private final String HostPassword = "say1472580";
    private String ValidCode = null;
    private final Timer timer = new Timer();
    private boolean flag = true;
    public static final int SMS_VALIDCODE_CORRECT = 0;// 手機驗證碼正確
    public static final int SMS_VALIDCODE_INCORRECT = 1;// 手機驗證碼錯誤
    public static final int OK = 2;
    public static final int REJECT = 3;

    public SMSController() {

    }

    // 產生驗證碼
    private String generateValidCode() {
        SecureRandom random = new SecureRandom();

        String validCode = "";// 儲存產生的驗證碼

        String digits;

        for (int i = 0; i < 6; i++) {
            digits = String.format("%d", random.nextInt(10));
            validCode = validCode + digits;
        }
        return validCode;
    }

    public int SendRequest() {
        if (flag == true)
            return OK;
        return REJECT;
    }

    // 發送手機驗證碼到使用者手機
    public void SendSMS(String phoneNumber) {
        try {
            // 設定變數 StringBuffer 使得String可以修改內容
            StringBuffer MSGData = new StringBuffer();

            // 設定參數
            String validCode = generateValidCode();
            String message = "歡迎使用Doge密碼管理系統，這是您的驗證碼:" + validCode + "請在5分鐘內使用"; // 簡訊內容
            this.ValidCode = validCode;
            MSGData.append("username=" + HostUsername);
            MSGData.append("&password=" + HostPassword);
            MSGData.append("&mobile=" + phoneNumber);
            MSGData.append("&message=");
            MSGData.append(UrlEncode(message.toString().getBytes("big5")));

            SendToGW(MSGData.toString());
            flag = false;
            timer.schedule(new ExpiredTask(), 5 * 60 * 1000);// 開始計時器 5分鐘後讓驗證碼失效

        } catch (Exception e) {
            System.out.println("程式錯誤!");
        }
    }

    // 傳送至 TwSMS API server
    private boolean SendToGW(String post) {
        try {

            URL url = new URL("http://api.twsms.com/json/sms_send.php");
            sms_gw = (HttpURLConnection) url.openConnection();
            sms_gw.setDoInput(true);
            sms_gw.setDoOutput(true);
            sms_gw.setUseCaches(false);
            sms_gw.setRequestMethod("POST");

            DataOutputStream dos = new DataOutputStream(sms_gw.getOutputStream());
            dos.writeBytes(post);
            dos.flush();
            dos.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(sms_gw.getInputStream()));
            String strResponse = "";
            String readLine;
            while ((readLine = br.readLine()) != null) {
                strResponse += readLine;
            }
            br.close();
            System.out.println("驗證碼寄送成功");
            return true;
        } catch (Exception e) {
            System.out.println("無法連接 TwSMS API Server!");
            return false;
        }
    }

    // UrlEncode Function
    private String UrlEncode(byte[] src) {
        byte[] ASCIIMAP = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
        int pivot = 0;
        byte[] data = new byte[src.length * 3];
        for (int i = 0; i < src.length; i++) {
            if (src[i] == 0) {
                data[pivot++] = 37;
                data[pivot++] = 48;
                data[pivot++] = 48;
            }

            else if (src[i] < 0) {
                data[pivot++] = 37;
                data[pivot++] = ASCIIMAP[(src[i] >> 4) & 0x0f];
                data[pivot++] = ASCIIMAP[src[i] & 0x0f];
            } else {
                char cc = (char) src[i];

                if (Character.isLetterOrDigit(cc)) {
                    data[pivot++] = src[i];
                } else if (cc == ' ') {
                    data[pivot++] = 43;
                } else if (cc == '.' || cc == '-' || cc == '*' || cc == '_') {
                    data[pivot++] = src[i];
                } else {
                    data[pivot++] = 37;
                    data[pivot++] = ASCIIMAP[(src[i] >> 4) & 0x0f];
                    data[pivot++] = ASCIIMAP[src[i] & 0x0f];
                }
            }
        }
        if (pivot > 0)
            return new String(data, 0, pivot);
        return "";
    }

    // 檢查使用者輸入的手機驗證碼是否正確
    public int ValidCodeVerify(String userInput) {

        try {
            if (ValidCode.equals(userInput)) {
                ValidCode = null;
                flag = true;
                return SMS_VALIDCODE_CORRECT;
            }
        } catch (Exception err) {// 找不到該電話的驗證碼
            return SMS_VALIDCODE_INCORRECT;
        }

        return SMS_VALIDCODE_INCORRECT;
    }

    // 計時器終止觸發事件
    class ExpiredTask extends TimerTask {
        public void run() {
            ValidCode = null;
            flag = true;
            System.out.println("手機驗證碼已過時效!");
        }
    }
}
