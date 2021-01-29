/**
* Name: Andhy Gomez
* Description: This program will add a min() function to stack that will operate in constant time
* Date last modified: 1/29/21
* Chapter: 3
* Question: 3.2
*/
public class StackMin 
{
	Stack<Integer> stack;
	Stack<Integer> stackOfMins;
	
	/**
	 * Description: Constructor method which creates two stacks, one is the actual stack, the other is a stack containing
	 * a history of minimum values of the stack
	 */
	public StackMin() 
	{
		stack = new Stack<Integer>();
		stackOfMins = new Stack<Integer>();
	}
	
	/**
	 * Description: Adds desired value to the top of the stack
	 * 
	 * @param value to be added
	 */
	void push(int value) 
	{
		stack.push(value);
		
		// check if there is a new minimum
		if(stackOfMins.isEmpty()) 
		{
			// if this stack is empty, the first value pushed becomes minimum
			stackOfMins.push(value);
		}
		else 
		{
			if(value < stackOfMins.peek()) 
			{
				// if value being pushed is less than previous min, add it as new min
				stackOfMins.push(value);
			}
		}
	}
	
	/**
	 * Description: Removes the element at the top of the stack (LIFO)
	 * 
	 * @return value which was just removed
	 */
	int pop() 
	{
		int top;
		
		// Store top of stack since it must be returned
		top = stack.pop();
		
		// If value being removed was minimum, remove that min value from stackOfMins
		if(top == stackOfMins.peek())
		{
			stackOfMins.pop();
		}
		
		return top;
	}
	
	/**
	 * Description: Returns the minimum of the stack in constant time
	 * 
	 * @return minimum value in stack
	 */
	int min() 
	{
		return stackOfMins.peek();
	}
	
	/**
	 * Description: Turns stack into a string
	 * 
	 * @return stack as a string
	 */
	String print() 
	{
		return stack.toString();
	}
	
	/**
	 * Description: Test Code
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		StackMin stack = new StackMin();
		
		stack.push(5);
		stack.push(3);
		stack.push(6);
		stack.push(2);
		stack.push(7);
		stack.push(1);
		
		System.out.println("Stack: " + stack.print());
		
		System.out.println("Minimum: " + stack.min());
		
		stack.pop();
		
		System.out.println("Stack: " + stack.print());
		System.out.println("Minimum: " + stack.min());
		
		stack.pop();
		stack.pop();
		
		System.out.println("Stack: " + stack.print());
		System.out.println("Minimum: " + stack.min());	
		
		stack.push(1);
		
		System.out.println("Stack: " + stack.print());
		System.out.println("Minimum: " + stack.min());
	}

}
