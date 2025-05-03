package com.truth.membership;

public class BasicMember extends Member{

    public BasicMember(String name, String profileDescription) {
        super(name, profileDescription);
    }

    @Override
    public String memberShipDescription() {
        return "Basic";
    }

    @Override
    public void renewMembership() {
        daysRemain = 30;
    }

    @Override
    public void showMember() {
        String msg = "";
        msg += "ID: " + memberId + "\n" ;
        msg += "Name: " + memberName + "\n" ;
        msg += "Bio: " + profileDescription + "\n";
        msg += "\nMembership Type: " + memberShipDescription() + "\n";
        msg += "Days Remain: " + daysRemain + "\n" ;
        msg += "\n" + Helper. COPY_RIGHT_NOTICE;
        javax.swing. JOptionPane.showMessageDialog(null, msg);
    }
}
