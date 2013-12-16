package amazon;

import java.util.ArrayList;
import java.util.Collection;

interface Member {
    public double getMonthlySales();

    public Collection<Member> getRecruitedMembers();
}

public class MemberPayoutUtil {

    public static void main(String[] args) {

	Collection<Integer> l = new ArrayList<Integer>();
	l.add(1);
	l.add(2);
	l.add(3);
	l.add(4);
	Collection<Integer> l2 = new ArrayList<Integer>();
	l2.add(5);
	l2.add(6);
	while (!l.isEmpty()) {
	    for (Integer i : l) {
		System.out.println(i);
	    }
	    l.clear();
	    l.addAll(l2);
	    l2.clear();
	}
    }

    public static double calculatePayout(Member member) {

	double payout = member.getMonthlySales() * 0.1;
	double sumForRecruits = 0;
	Collection<Member> recruitedMembers = member.getRecruitedMembers();
	Collection<Member> newRecruits = new ArrayList<Member>();
	while (!recruitedMembers.isEmpty()) {
	    for (Member recruit : recruitedMembers) {
		sumForRecruits += recruit.getMonthlySales();
		newRecruits.addAll(recruit.getRecruitedMembers());
	    }
	    recruitedMembers.clear();
	    recruitedMembers.addAll(newRecruits);
	    newRecruits.clear();
	}
	return payout + sumForRecruits * 0.04;
    }
}
