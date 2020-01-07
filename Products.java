import java.util.ArrayList;

public class Products {
	 public int findDays(int day, int month, int year) {
		 Date date = new Date();
		 SimpleDateFormat sdfd = new SimpleDateFormat("dd");
		 String ds = sdfd.format(date); // ds = dayString
		 int di = Integer.parseInt(ds); // di = dayint μετατρέπει String σε int
		 SimpleDateFormat sdfm = new SimpleDateFormat("MM");
		 String ms = sdfm.format(date); // ms = monthString
		 int mi = Integer.parseInt(ms); // mi = monthint μετατρέπει String σε int
		 SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
		 String ys = sdfy.format(date); // ys = yearString
		 int yi = Integer.parseInt(ys); // yi = yearint μετατρέπει String σε int
		 int diff=0;
	 }
	 
	 if (di >= day && mi > month + 1 && yi == year) {
		 diff = di - day;
		 for (int x = month; x > mi; x++) {
			 diff += dom(month, year);
		 }
	 } else if (di >= day && mi > month + 1 && yi > year) {
		 diff = di - day;
		 if (yi == year + 1) {
			 if (yi % 400 == 0 || (yi % 100 != 0 && yi % 4 != 0)) {
				 diff += 366;
			 } else {
				 diff += 365;
			 }
		 }
		 for (int x = month; x > mi; x ++) {
			 diff += dom(x, year);
		 }
		 diff += di;
	 } else if (di < day && mi > month + 1 && yi == year + 1) {
		 diff = diff += dom(month, year);
		 for (int i = month + 1; i <= 12; i++) {
			 diff += dom(i, year);
		 }
		 if (mi == 1) {
			 diff += di;
		 } else {
			 for (int i = 1; i <= mi; i++) {
				 diff += di;
			 }
		 }
	 
	  public int dom(int m, int y) { // dom = DaysOfMonth
	    	 int z;
	    	 if ((m % 2 != 0 && m >= 1 && m <= 7) || (m % 2 == 0 && m > 7 && m <= 12)) {
	    		 z = 31;
	    	 }
	    	 else if (m == 2) {
	    		 if (y % 400 == 0 || (y % 100 != 0 && y % 4 != 0)) {
	    			 z = 29;
	    		 } else {
	    			 z = 28;
	    		 }
	    	 } else {
	    		 z = 30;
	    	 }
	    	 return z;
	  } 
    	 
	  ArrayList<Integer> samecode = new ArrayList<Integer>(); // contains days passed
	  ArrayList<Integer> samecodeindex = new ArrayList<Integer>();
		
	 public void purchase(int code, int quantity) {
		int sum = 0;
		for (int i = 0; i < Arraylist.size() ; i++) { // arraylist of product class
			if (Arraylist.get(i).getCode().equals(code))
				samecode.add(findDate(Arraylist.get(i)));
			    samecodeindex.add(i);
			    sum = sum + Arraylist.get(i).getQuantity();
		}
		if (Quantity > sum) {
			System.out.println("Sorry!We do not have so many items of this product.");
		    return;
		} else if (samecode.size() > 1) {
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				for (int i = 0; i < samecode.size(); i++) {
					if (samecode.get(i) < samecode.get(i + 1)) {
						 int temp1 = samecode.get(i);
						 samecode.get(i) = samecode.get(i + 1);
						 samecode.get(i + 1)= temp;
				         int temp = samecodeindex(i);
				         samecodeindex(i) = samecodeindex(i + 1);
				         samecodeindex(i + 1) = temp;
				         sorted = false;
					}
				}
		    }
			for (int i = 0; i < samecode.size(); i++) {
				quantity(quantity);
			}
		} else {
			quantity(quantity);
		}
	}
	
	 public void quantity(int quantity) {
		if (quantity < Arraylist.get(samecodeindex(i)).getQuantity())
			Arraylist.get(samecodeindex(i)).setQuantity(Arraylist.get(samecodeindex(i)).getQuantity() - quantity);
		else if (quantity == Arraylist.get(samecodeindex(i)).getQuantity())
			Arraylist.remove(samecodeindex(i));
		else {
		    quantity = quantity - Arraylist.get(samecodeindex(i)).getQuantity();
		    Arraylist.remove(samecodeindex(i));
	    }
	}
}
