package com.truth.membership;


import com.truth.membership.memInter.Renewable;
import com.truth.membership.memInter.Showable;

public abstract class Member implements Renewable, Showable {
    public long memberId;
    public String memberName;
    public String profileDescription;
    protected int daysRemain = 0;

    public Member(String name, String profileDescription){
        memberId = Helper.generateUniqueLng();
        memberName  = name;
        this.profileDescription = profileDescription;

        renewMembership();
        showMember();

    }

    public abstract String memberShipDescription();

    public final int getPopularity(){
        return memberId % 2 == 0? 100: 1;
    }

}
