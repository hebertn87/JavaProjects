package hebenathproj4;

//Polynomial Class
public class Poly
{
    //New node class head and tail refs
    Node head = new Node(0,0);
    Node tail = head;
    
    //Node class for poly's
    public class Node
    {
       int coef, pow;
       Node next;
       
       Node(int coef, int pow)
       {
           this.coef = coef;
           this.pow = pow;
       }      
    }
    
    //Constructor
    Poly()
    {
        head = null;
    }
     
    //Returns the coefficient based on the power asked for
    public int getCoef(int power, Node cur)
    {
        cur = head;
        if (power == cur.pow) //If the power given is the one in head, return that coef
        {
            return cur.coef;
        }
        else
        {
            while (cur.pow != power) //while the power doesnt equal the once given, go to next node
            {
                cur = cur.next;
            }
            return cur.coef;
        } 
    }
    
    //Sets the power and coefficient for a term
    public void setCoef(int coef, int power, Node cur)
    {
        cur = head;
        if (cur == null)
        {
           cur = new Node(coef, power);
           cur.next = null;
        }
        else if(power > cur.pow)
        {
          Node newnode = new Node(coef, power);
          newnode.next = cur;
          head = newnode;
        }
        else if (power < cur.pow)
        {
          Node newnode = new Node(coef, power);
          
          while (power < cur.pow)
          {
            cur = cur.next;
             
          }
          cur.next = newnode;
        }
    }
    
    //Evaluates the expression 
    public double eval(double x, Node cur)
    {
        double eval = 0;
        cur = head;
        if (cur != null)
        {
           eval = cur.coef*Math.pow(x, cur.pow);
           eval(x, cur.next);     
        }
        else;
        
        return eval;
    }
    
    //Converts the nodes to a string
    public String toaString(Node cur)
    {
        String result = "";
        cur = head;
        do
        {
            cur = cur.next;
            result += (cur.coef + "x^" + cur.pow);
        }
        while (cur.next != null);
        
        return result;
    }
    
    //Adds 2 polynomials together
    public Node add(Node first, Node second)
    {
        head = null;
        Node cur = null;
        
        //While the the nodes are not empty
        while (null!=first || null!=second)
        {
            boolean pickfirst = false;
            boolean haveBoth = (null!=first && null!=second);

            Node node;
            //if both first and second nodes equal powers, add their coefs and keep the power
            if (haveBoth && first.pow == second.pow)
            {
                node = new Node(first.coef + second.coef, first.pow);
                first = first.next;
                second = second.next;
            } 
            //Else find if others will add, if not, puth them in order from largest to smallest
            else
            {
                pickfirst = first!=null && ((second == null) || first.pow > second.pow);
                if (pickfirst)
                {
                    node = new Node(first.coef, first.pow);
                    first = first.next;
                } 
                else
                {
                    node = new Node(second.pow, second.pow);
                    second = second.next;
                }
            }
            //If current is null.
            if (cur == null)
            {
                head = node;
                cur = head;
            } 
            else
            {
                cur.next = node;
                cur = node;
            }
        }

        return head;
    }
}
