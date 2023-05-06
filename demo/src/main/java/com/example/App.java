package com.example;

public class App {
    public static void main(String[] args) throws Exception {

        // SMSController smsController = new SMSController();
        // smsController.SendSMS("0974002156");
        // Scanner input = new Scanner(System.in);
        // int code = input.nextInt();
        // System.out.println(smsController.ValidCodeVerify("0974002156",
        // String.format("%d", code)));
        // MailController mailController = new MailController();
        // mailController.sendMail("say859462@yahoo.com.tw");
        // AccountController accounterController = new AccountController();
        // accounterController.regiserAccount("test001@gmail.com", "test001",
        // "0909000222");
        // System.out.println(accounterController.AccountIsCorrect("test001@gmail.com",
        // "test001"));
        // System.out.println(accounterController.reapeatedAccount("ss66112"));
        // accounterController.regiserAccount("test001@gmail.com", "test002",
        // "0986577869");
        // accounterController.disconnectMongoDB();

        UserInterface tmp = new UserInterface("test001@gmail.com");
        // tmp.deleteOneUserData("Discord", "test01", "test01@%");
        // tmp.updateOneUserData("Discord", "test01", "test01@%Sa");
        // tmp.updateOneUserData("Google", "hi@gmail.com", "saysay");
        // List<RecordData> result = new ArrayList<>();
        // result = tmp.fetchAllUserData();

        // for (int i = 0; i < result.size(); i++) {
        // System.out.println(result.get(i).getAppName() + " " +
        // result.get(i).getUsername());
        // }
        RandomPasswordGenerator gen = new RandomPasswordGenerator();
        System.out.println(
                gen.PasswordGenerate(15, RandomPasswordGenerator.LowerCase, RandomPasswordGenerator.UpperCase,
                        RandomPasswordGenerator.Special, RandomPasswordGenerator.Digits));

    }
}
