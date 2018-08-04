package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import java.io.IOException;



public class Controller extends ToFxml{

@FXML
    public TextField password;
    @FXML
    public TextField title;
    @FXML
    public TextField body;
    @FXML
    public TextField gmail;
    @FXML
    public TextField target;

    public void button(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "از ارسال ایمیل اطمینان دارید؟", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            //do stuff
            if(!title.getText().equals("") && !gmail.getText().equals("") && !password.getText().equals("") && !body.getText().equals("") && !target.getText().equals("")) {

        Mailer.send(gmail.getText(), password.getText(), target.getText(), title.getText(), body.getText());

    }
            else {
                Alert t = new Alert(Alert.AlertType.WARNING, "please Fill all text filed", ButtonType.OK);
                t.showAndWait();
                if(t.getResult() == ButtonType.OK) {
                    return;
                }
            }


            }
        }

 //       ToFxml("Second.fxml", "", Main.FirstStage);




    @Override
    public void ToFxml(String fxmlname, String name, Stage First) {

        super.ToFxml(fxmlname, name, First);
    }
}
class Mailer {
    public static void send(String from, String password, String to, String sub, String msg) {

            //Get properties object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            //get Session
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(from, password);
                        }
                    });
            //compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject(sub);
                message.setText(msg);
                //send message
                Transport.send(message);
                Alert t = new Alert(Alert.AlertType.INFORMATION, "message sent successfully", ButtonType.OK);
                t.showAndWait();
                System.out.println("");

            } catch (MessagingException e) {
                throw new RuntimeException(e);

            }


    }
}
