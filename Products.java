import java.util.ArrayList;

public class Products {
	 public int findDays(int day, int month, int year) {
    	 Date date = new Date();
    	 SimpleDateFormat sdfd = new SimpleDateFormat("dd");
    	 String ds = sdfd.format(date); // ds=dayString
    	 int di = Integer.parseInt(ds); // di=dayint μετατρέπει String σε int
    	 SimpleDateFormat sdfm = new SimpleDateFormat("MM");
    	 String ms = sdfm.format(date); // ms=monthString
    	 int mi = Integer.parseInt(ms); // mi=monthint μετατρέπει String σε int
    	 SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
    	 String ys = sdfy.format(date); // ys=yearString
    	 int yi = Integer.parseInt(ys); // yi=yearint μετατρέπει String σε int
    	 int diff=0;
	 }
	 
	  public int dom(int m, int y) { // dom=DaysOfMonth
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
    	 
	 public void purchase(int code, int quantity) {
		ArrayList<Integer> samecode = new ArrayList<Integer>(); /*contains days passed*/
		ArrayList<Integer> samecodeindex = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < Arraylist.size() ; i++) { /*arraylist of product class*/
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
				for (int i = 0; i<samecode.size(); i++) {
					if (samecode.get(i)<samecode.get(i + 1)) {
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
			Arraylist.get(samecodeindex(i)).setQuantity(Arraylist.get(samecodeindex(i)).getQuantity - quantity);
		else if (quantity == Arraylist.get(samecodeindex(i)).getQuantity())
			Arraylist.remove(samecodeindex(i));
		else {
			Arraylist.remove(samecodeindex(i));
		    quantity = quantity - Arraylist.get(samecodeindex(i)).getQuantity();
	    }
	}
}
