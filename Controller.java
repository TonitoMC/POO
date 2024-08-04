import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private View mainView;
    private Model mainModel;
    public Controller(View mainView, Model mainModel){
        this.mainView = mainView;
        this.mainModel = mainModel;
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == mainView.getRegisterButton()){
            //Register new user
        }
        if (e.getSource() == mainView.getCalculateButton()){
            //Create new unregistered user with data input
        }
        if (e.getSource() == mainView.getLoginButton()){
            //Log user in
        }
    }

}
