package hashmaster;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Controller {

    public TextField txtSHA1;
    public TextField txtSHA256;
    public TextField txtSHA512;
    public TextField txtMSG;
    public String calcValue;

    // String finalValue = "";

    public void txtSHA1Func(String calcValue) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        // calcValue = this.txtSHA1.getText();
        // System.out.println("SHA1 :" + calcValue);
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(calcValue.getBytes("utf8"));
        String sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        this.txtSHA1.setText(sha1);
    }

    public void txtSHA256Func(String calcValue) throws NoSuchAlgorithmException {
//        calcValue = txtSHA256.getText();
        // System.out.println("SHA256: " + calcValue);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(calcValue.getBytes(StandardCharsets.UTF_8));
        String toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
        // System.out.println(toReturn);
        this.txtSHA256.setText(toReturn);
    }

    public void txtSHA512Func(String calcValue) throws NoSuchAlgorithmException {
        // System.out.println("SHA512: " + calcValue);

        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        digest.reset();
        digest.update(calcValue.getBytes(StandardCharsets.UTF_8));
        String toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
        // System.out.println(toReturn);
        this.txtSHA512.setText(toReturn);
    }


    public void btnCalcValue(ActionEvent event) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        if(txtMSG.getText() == "" )
        {
            System.out.println("Enter in a value in one of the text fields.");
        } else {
            txtSHA1Func(txtMSG.getText());
            txtSHA256Func(txtMSG.getText());
            txtSHA512Func(txtMSG.getText());
        }

    }

    public void btnExit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
}
