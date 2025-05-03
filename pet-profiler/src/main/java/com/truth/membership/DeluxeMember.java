package com.truth.membership;

public class DeluxeMember extends Member{
    public DeluxeMember(String name, String profileDescription) {
        super(name, profileDescription);
    }

    @Override
    public String memberShipDescription() {
        return "Deluxe";
    }

    @Override
    public void renewMembership() {
        daysRemain = 999999;
    }

    @Override
    public void showMember() {
        String msg= "";
        msg += "ID: " + memberId + "\n" ;
        msg += "Name: " + memberName + "\n" ;
        msg += "Bio: " + profileDescription + "\n";
        msg += "\nMembership Type: " + memberShipDescription() + "\n";
        msg += "Days Remain: " + daysRemain + "\n" ;
        msg += "\n" + Helper. COPY_RIGHT_NOTICE;
        javax.swing. JOptionPane.showMessageDialog(null, msg);
    }
}
