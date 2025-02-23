import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainScreen extends JFrame {

    //Panel1: User Registration
    JPanel subscriberPanel;
    JTextField subName;
    JTextField subLastName;
    JTextField subMobile;
    JTextField subCity;

    JLabel nameLBL;
    JLabel lastLBL;
    JLabel mobileLBL;
    JLabel cityLBL;

    // Panel 2: Cycle
    JTextField startCycleFLD;
    JTextField endCycleFLD;
    JTextField numberTVFLD;
    JLabel todayLBL;
    JPanel cyclePanel;
    SimpleDateFormat df;
    Date currentDate;
    JLabel startCycleLBL;
    JLabel endCycleLBL;
    JLabel numberTVLBL;


    // Panel3: Channels' packages
    JCheckBox sportsCHKBX;
    JCheckBox moviesCHKBX;
    JCheckBox docCHKBX;
    JPanel packagesPanel;

    //Panel4:  Package details
    JTextArea channelsAreaS;
    JTextArea channelsAreaM;
    JTextArea channelsAreaD;
    JPanel detailsPanel;

    //Panel5: Check and Payments
    JLabel installFeeLBL;
    JPanel feePanel;
    JLabel packageFeeLBL;
    JLabel totalFeeLBL;

    //Panel6 : Table (Data of Subscription)
    JTable table;
    DefaultTableModel tableModel;
    JPanel p6panel;


    //Panel7: Action Panel
    JButton saveBTN;
    JButton loadBTN;
    JButton newBTN;
    JPanel p7ActionPanel;



    // Classes and Objects
    Subscriber subscriber;
    Subscription subscription;


    //Constructor
    public MainScreen() {

        /**********************888888888888888 PANEL 1 *******************/
        subscriberPanel = new JPanel();
        Border panel1Title = BorderFactory.createTitledBorder("Subscriber Details");
        subscriberPanel.setBorder(panel1Title);
        subscriberPanel.setBounds(15, 15, 300, 200);
        subscriberPanel.setLayout(new GridLayout(4, 2));


        //JLabel
        nameLBL = new JLabel("Name:  ");
        lastLBL = new JLabel("Last Name: ");
        mobileLBL = new JLabel("Mobile: ");
        cityLBL = new JLabel("City: ");

        //TextFields
        subName = new JTextField();
        subName.setOpaque(false);
        subLastName = new JTextField();
        subLastName.setOpaque(false);
        subMobile = new JTextField();
        subMobile.setOpaque(false);
        subCity = new JTextField();
        subCity.setOpaque(false);

        //Adding components to panel1
        subscriberPanel.add(nameLBL);
        subscriberPanel.add(subName);
        subscriberPanel.add(lastLBL);
        subscriberPanel.add(subLastName);
        subscriberPanel.add(mobileLBL);
        subscriberPanel.add(subMobile);
        subscriberPanel.add(cityLBL);
        subscriberPanel.add(subCity);
        /*************  PANEL 2 **************************/

        cyclePanel = new JPanel();
        cyclePanel.setBounds(15, 230, 300, 500);
        cyclePanel.setLayout(new GridLayout(14, 1));

        Border cycleBorder = BorderFactory.createTitledBorder("Cycle Details");
        cyclePanel.setBorder(cycleBorder);

        //Components of cycle panel
        todayLBL = new JLabel();
        df = new SimpleDateFormat("dd/MM/yyyy");
        currentDate = new Date();
        todayLBL.setText("Today: " + df.format(currentDate));

        //start cycle
        startCycleLBL = new JLabel("Start Cycle Date(DD/MM/YYYY) ");
        startCycleFLD = new JTextField();

        //end cycle date
        endCycleLBL = new JLabel("End Cycle Date(DD/MM/YYYY)");
        endCycleFLD = new JTextField();

        //Number of TVS
        numberTVLBL = new JLabel("Numer of TV:");
        numberTVFLD = new JTextField();

        cyclePanel.add(todayLBL);
        cyclePanel.add(startCycleLBL);
        cyclePanel.add(startCycleFLD);
        cyclePanel.add(endCycleLBL);
        cyclePanel.add(endCycleFLD);
        cyclePanel.add(numberTVLBL);
        cyclePanel.add(numberTVFLD);

        //make opacity for fields
        startCycleFLD.setOpaque(false);
        endCycleFLD.setOpaque(false);
        numberTVFLD.setOpaque(false);


        /*************  PANEL 3 **************************/
        packagesPanel = new JPanel();
        packagesPanel.setBounds(330, 15, 300, 200);
        packagesPanel.setLayout(new GridLayout(5, 1));

        Border packBorder = BorderFactory.createTitledBorder("Available Packages");
        packagesPanel.setBorder(packBorder);

        JLabel packagesLBL = new JLabel("Please select your Package");
        sportsCHKBX = new JCheckBox("Sport Package");
        moviesCHKBX = new JCheckBox("Movies Package");
        docCHKBX = new JCheckBox("Documentary Package");

        JButton subscribeBTN = new JButton("Subscribe");

        packagesPanel.add(packagesLBL);
        packagesPanel.add(sportsCHKBX);
        packagesPanel.add(moviesCHKBX);
        packagesPanel.add(docCHKBX);
        packagesPanel.add(subscribeBTN);

        //Check Item Listeners
        sportsCHKBX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sportsCHKBX.isSelected()) {
                    DisplaySportChannels();
                    // make price changes
                } else {

                }
            }
        });

        moviesCHKBX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (moviesCHKBX.isSelected()) {
                    DisplayMoviesChannels();
                } else {

                }
            }
        });

        docCHKBX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (docCHKBX.isSelected()){
                    DisplayDocumentaryChannels();
                }else {

                }
            }
        });
        subscribeBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GetSubscriberData();
                }catch (Exception ee){

                }
            }
        });
/********** Panel 4   *******************************/

         detailsPanel = new JPanel();
         detailsPanel.setBounds(330,230,300,500);
         detailsPanel.setLayout(new GridLayout(3,1));

         Border p4Border = BorderFactory.createTitledBorder("Available Channel");
         detailsPanel.setBorder(p4Border);

         channelsAreaS =new JTextArea(5,1);
         channelsAreaS.setEditable(false);
         channelsAreaS.setOpaque(false);
         channelsAreaS.setLineWrap(true);

        channelsAreaM =new JTextArea(5,1);
        channelsAreaM.setEditable(false);
        channelsAreaM.setOpaque(false);
        channelsAreaM.setLineWrap(true);

        channelsAreaD =new JTextArea(5,1);
        channelsAreaD.setEditable(false);
        channelsAreaD.setOpaque(false);
        channelsAreaD.setLineWrap(true);

        detailsPanel.add(channelsAreaS);
        detailsPanel.add(channelsAreaM);
        detailsPanel.add(channelsAreaD);

        /******************* Panel 5 ****************/

        feePanel = new JPanel();
        feePanel.setBounds(645,15,200,200);
        feePanel.setLayout(new GridLayout(3,1));

        Border blackline5 = BorderFactory.createTitledBorder("Fee & Check");
        feePanel.setBorder(blackline5);

        installFeeLBL = new JLabel("Installation Fee: ");
        packageFeeLBL = new JLabel("Package Fee: ");
        totalFeeLBL  = new JLabel("Total Amount to Pay: ");

        feePanel.add(installFeeLBL);
        feePanel.add(packageFeeLBL);
        feePanel.add(totalFeeLBL);

        /******************* Panel 6 ****************/
        p6panel = new JPanel ();
        p6panel.setBounds(645,230,515,500);
        p6panel.setLayout( new GridLayout(3,1));

        Border border6 = BorderFactory.createTitledBorder("Our Customers");
        p6panel.setBorder(border6);

        //Table:
        //1- table Model
        tableModel =new DefaultTableModel();

        //2- Columns
        table = new JTable(tableModel);
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Start Cycle");
        tableModel.addColumn("End Cycle");
        tableModel.addColumn("Total Fee");


        //3 - Scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        p6panel.add(scrollPane);


     /***************************** Panel 7 ***********************/
     p7ActionPanel = new JPanel();
     p7ActionPanel.setBounds(860,15,300,200);

     Border border7 = BorderFactory.createTitledBorder("Action Tab");
     p7ActionPanel.setBorder(border7);
     p7ActionPanel.setLayout(new GridLayout(4,1));
     saveBTN = new JButton("Save Subscription");
     loadBTN = new JButton("Load Subscription");
     newBTN = new JButton("New Subscription");

     p7ActionPanel.add(newBTN);
     p7ActionPanel.add(saveBTN);
     p7ActionPanel.add(loadBTN);


     saveBTN.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             SaveSubscriptionTODisk();
         }
     });
     newBTN.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             NewSubscription();

         }
     });

     loadBTN.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             LoadDataFromDisk();
         }
     });









        //Adding Panels to JFRAME
        setLayout(null);      // null layout for jframe
        add(subscriberPanel); //panel 1
        add(cyclePanel);      //panel 2
        add(packagesPanel);   //panel 3
        add(detailsPanel);    //panel 4
        add(feePanel);        //panel 5
        add(p6panel);         //panel 6
        add(p7ActionPanel);   //panel 7

    }




    /************************                METHODS                            ***********/
    /************  We will add methods in later videos ******/
    private  void GetSubscriberData() {

     /*  Date currentDate = new Date();

        // Subscriber Data :
        subscriber = new Subscriber(
                subName.getText(),
                subLastName.getText(),
                subCity.getText(),
               Integer.parseInt(subMobile.getText()));


                // Cycle
            Date startCycle = df.parse(startCycleFLD.getText());
            Date endCycle = df.parse(endCycleFLD.getText());

            SubscriptionCycle cycle = new SubscriptionCycle(
                    df.format(startCycle),
                    df.format(endCycle)
            );

            //Subscription
        subscription = new Subscription(
                Integer.parseInt(numberTVFLD.getText()),
                subscriber,
                cycle,
                df.format(currentDate)
        );
        installFeeLBL.setText("Installation Fee:"+
                subscription.getTotalFee()+ "$");

        ShowPrice();*/

    }
    private  void ShowPrice (){

    }


    private  void DisplaySportChannels() {
      SportChannel  s1 = new SportChannel("AFN Sport","EN","SPRT",5);
      SportChannel  s2 = new SportChannel("beIn Sport","FR","SPRT",3);
      SportChannel  s3 = new SportChannel("Eleven Sport","EN","SPRT",8);
      SportChannel  s4 = new SportChannel("NBA TV","EN","SPRT",6);
      SportChannel  s5 = new SportChannel("NFL Network", "AR","SPRT",6);
      SportChannel  s6 = new SportChannel("THE Ski Channel","USA","SPRT",1);

        ArrayList<SportChannel> sportList = new ArrayList<>();
        sportList.add(s1);
        sportList.add(s2);
        sportList.add(s3);
        sportList.add(s4);
        sportList.add(s5);
        sportList.add(s6);

        String sprtChannelString = "";
        for (int i = 0; i < sportList.size(); i++) {
            sprtChannelString +=
                    "           " +sportList.get(i).getChannelName()
                            + "          " + sportList.get(i).getLanguage()
                            + "           " + sportList.get(i).getPrice()
                            + "\n";

        }
        channelsAreaS.setText(sprtChannelString);



    }

    private void DisplayMoviesChannels() {
        MovieChannel m1 = new MovieChannel("MBC Bundle", "SP", "EN", 4);
        MovieChannel m2 = new MovieChannel("Cinema One", "USA", "EN", 5);
        MovieChannel m3 = new MovieChannel("Cinema Pro", "UK", "EN", 6);
        MovieChannel m4 = new MovieChannel("Cinema 1", "USA", "EN", 2);
        MovieChannel m5 = new MovieChannel("Movie Home", "UK", "EN", 4);
        MovieChannel m6 = new MovieChannel("Film4", "GR", "EN", 2);

        ArrayList<MovieChannel> movielist = new ArrayList<>();
        movielist.add(m1);
        movielist.add(m2);
        movielist.add(m3);
        movielist.add(m4);
        movielist.add(m5);
        movielist.add(m6);


        String movChannelString = "";
        for (int i = 0; i < movielist.size(); i++) {
            movChannelString +=
                    "           " + movielist.get(i).getChannelName()
                            + "          " + movielist.get(i).getLanguage()
                            + "           " + movielist.get(i).getPrice()
                            + "\n";

        }
        channelsAreaM.setText(movChannelString);
    }
    private  void DisplayDocumentaryChannels() {
        DocumentaryChannel m1 =new DocumentaryChannel( "NAT GEO", "SP","DOC",3);
        DocumentaryChannel m2 =new DocumentaryChannel("PBS America","EN","DOC",2);
        DocumentaryChannel m3 =new DocumentaryChannel("Al Jazeera Documentary","IN","DOC",3);
        DocumentaryChannel m4 =new DocumentaryChannel("Canal D","USA","EN",4);
        DocumentaryChannel m5 =new DocumentaryChannel("Discovery Historia","AR","DOC",5);
        DocumentaryChannel m6 =new DocumentaryChannel("World Documentary","GR","DOC",1);

        ArrayList<DocumentaryChannel> documentaryChannels = new ArrayList<>();
        documentaryChannels.add(m1);
        documentaryChannels.add(m2);
        documentaryChannels.add(m3);
        documentaryChannels.add(m4);
        documentaryChannels.add(m5);
        documentaryChannels.add(m6);

    String docChannelString = "";
    for (int i = 0; i < documentaryChannels.size(); i++){
       docChannelString +=
                "           "+ documentaryChannels.get(i).getChannelName()
               + "          "+documentaryChannels.get(i).getLanguage()
               + "           "+documentaryChannels.get(i).getPrice()
               + "\n";

    }
    channelsAreaD.setText(docChannelString);

    }
    private static void SaveSubscriptionTODisk() {

    }
    private static void  NewSubscription() {

    }
    private static void  LoadDataFromDisk() {

    }




    public static void main(String[] args){
            MainScreen mainScreen = new MainScreen();
            mainScreen.setVisible(true);
            mainScreen.setBounds(20,10,12000,8000);
    }
}
