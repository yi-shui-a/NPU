/**
 * This class contains methods to process arrays of {@link Project} objects.
 *
 * @author  author name
 * @version  1.0.0
 * @see  Project
 */
public class  ProjectArray  {

	/**
	 * Creates an array with three objects of class {@link Project}.
	 * <p>
	 * The first element of the array is the object
	 * <code>first</code>, the second element of the array is
	 * the object <code>second</code>, and  the third element of the
	 * array is the object <code>third</code>.
	 * </p>
	 *
	 * @param first  a {@link Project} object.
	 * @param second  a {@link Project} object.
	 * @param third  a {@link Project} object.
	 * @return  an array with the objects <code>first</code>,
	 *           <code>second</code>, and <code>third</code>.
	 */
	public static Project[] makeArray(Project  first, Project  second,
									  Project  third)  {

		Project[] array={first,second,third};
		if (array == null)
			return null;
		else return array;
	}

	/**
	 * Creates a new array from the specified array of {@link Project}
	 * objects.
	 * <p>
	 * The elements in the new array have the same order as those in
	 * the specified array.
	 * </p>
	 *
	 * @param array  an array that contains objects of class {@link Project}.
	 * @return  a <i>new</i> array of the objects in the specified array.
	 */
	public static Project[] copyArray(Project[]  array)  {

		if(array==null)
			return null;
		else return array;
	}


	/**
	 * Returns the {@link Project} object with the specified ID.
	 *
	 * @param array  an array that contains objects of class {@link Project}.
	 * @param id  an Project ID.
	 * @return  The {@link Project} object with the specifed
	 *          ID. Returns <code>null</code> if there are no Projects
	 *          in the specified array with the specifed ID.
	 */
	public static Project getProject(Project[]  array, int id)  {

		for(Project n:array){
			if(n.getId()==id)
				return n;
		}
		return null;
	}

	/**
	 * Returns the number of Projects whose price is Lower than the specified
	 * dollar amount.
	 *
	 * @param array  an array that contains objects of class {@link Project}.
	 * @param amount  a dollar amount.
	 * @return  the number of Projects whose price is Lower than the
	 *          specified dollar amount.
	 */
	public static int countLowerPrice(Project[]  array, double amount)  {

		int num=0;
		for(Project n:array){
			if(n.getPrice()<amount)
				num=num+1;
		}
		return num;
	}

	/**
	 * Returns the sum of the price of the Projects in the specified
	 * array.
	 *
	 * @param array  an array that contains objects of class {@link Project}.
	 * @return  the sum of the price of the Projects in the specified
	 *          array.
	 */
//	for-each loop
	public static double sumPrice(Project[]  array)  {

		double num=0;
		if(array==null)
			return 0;
		for(Project n:array){
			num=num+n.getPrice();

		}
		return num;
	}

	/**
	 * Obtains the Lowest price in the specified array.
	 *
	 * @param array  an array that contains objects of class {@link Project}.
	 * @return  the Lowest price in the specified array.
	 */

//	for-each loop
	public static double getLowestPrice(Project[]  array)  {

		double num=array[0].getPrice();
		if(num==0)return 0;
		for(Project n:array){
			if(n.getPrice()<num)
				num=n.getPrice();
		}
		return num;
	}

	/**
	 * Increases the Price of every Project in the specified array by the
	 * specified amount.
	 *
	 * @param array  an array that contains objects of class {@link Project}.
	 */
//	for-each loop
	public static void increaseAll(Project[] array, double amount)  {

		if(array==null)return;
		Double num;
		for(Project n:array){
			num=n.getPrice();
			n.setPrice(num+amount);
		}
	}

	/**
	 * Returns a string representation of the specified
	 * {@link Project} array.
	 * <p>
	 * Uses the method <code>toString</code> in class <code>Project</code>
	 * to obtain the string representation of each object in the array.
	 * </p>
	 * A new line character ( \n ) separates the string representations
	 * of each <code>Project</code> object. For example:
	 * </p>
	 * <pre>
	 * Project[102,cruise,68250.0]\n
	 * Project[101,domestic,36000.0]\n
	 * Project[103,outbound,92175.0]
	 * </pre>
	 * <p>
	 * Note that the string returned does <i>not</i> end with a new line
	 * character (\n).
	 * </p>
	 * <p>
	 * This method assumes that every element in the specified array
	 * contains a valid reference to an <code>Project</code> object.
	 * </p>
	 *
	 * @param array  an array that contains objects of class {@link Project}.
	 * @return  the string representation of the specified array
	 */
	public static String displayAll(Project[]  array)  {

		if(array==null)
			return "error";
		String str="";
		int temp=0;
		for(Project n:array){
			str=str.concat(String.valueOf(n.toString()));
			temp=temp+1;
			if(array.length>temp)
				str=str.concat("\n");
		}
		return str; // REMOVE; USED SO THIS FILE COMPILES
	}
}