public class FloorsArrayList implements DynamicSet {

	private int size;
	private FloorsArrayLink first;
	private FloorsArrayLink last;
	
    public FloorsArrayList(int N){ 
    // constructor that builds a new list with 2 links - negative infinity and positive infinity, 
    // each with pointer arrays with size == N
    	this.size = 0;
    	this.first = new FloorsArrayLink(Double.NEGATIVE_INFINITY,N);
    	this.last = new FloorsArrayLink(Double.POSITIVE_INFINITY,N);
    	int i = N-1;
    	while (i>0) // adds default pointers from the minus infinity link to the infinity link
    	{
    		first.setNext(i, last);
    		last.setPrev(i, first);
    	}
    }

    public int getSize(){
    // returns the size of the FloorsArrayList 
        return this.size;
    }

    
    public FloorsArrayLink search(double key) {
    // function that finds the link that it's key is the biggest that is smaller or equal to key
    	FloorsArrayLink current=first;
    	int i = size - 1;
    	while (i >= 0)
    	{
	    	while(current.getNext(i).getKey() <= key) {
		    	current = current.getNext(i);
	    	}
	    	i=i-1;
    	}
    	return current;
    }
    
    public void insert(double key, int arrSize) { 
    // inserts a new FloorArrayLink and updates all of the pointers accordingly 
    	FloorsArrayLink newLink = new FloorsArrayLink(key,arrSize);
    	FloorsArrayLink found = search(key);
    	if (found.getKey() != key)
    	{
			updateAddPointerPrev(newLink, found);
			updateAddPointerNext(newLink, found.getNext(0));
    	}
    	this.size = this.size + 1;
    }
    
    
    
    public void updateAddPointerNext(FloorsArrayLink newLink,FloorsArrayLink after)
    //updates the all of the right pointers of the new link and the left pointers that point to it
    {
    	FloorsArrayLink curr = after;
    	int i = 0;	
    	while (i<newLink.getArrSize()) {
    
        	while (i<newLink.getArrSize() && curr.getArrSize() > i)
        	{
        		newLink.setNext(i, curr);
        		curr.setPrev(i, newLink);
        		i=i+1;
        	}
        	
        	i=i-1;
        	curr = curr.getNext(i);
        	i=i+1;
    	}
    }
    
    public void updateAddPointerPrev(FloorsArrayLink newLink,FloorsArrayLink before)
    //updates the all of the left pointers of the new link and the right pointers that point to it
    {
    	FloorsArrayLink curr = before;
    	int i = 0;	
    	while (i<newLink.getArrSize()) {
    
        	while (i<newLink.getArrSize() && curr.getArrSize() > i)
        	{
        		
        		newLink.setPrev(i, curr);
        		curr.setNext(i, newLink);
        		i=i+1;
        	}
        	
        	i=i-1;
        	curr = curr.getPrev(i);
        	i=i+1;
    	}
    }

    public void remove(FloorsArrayLink toRemove) {
    // removes an existing FloorArrayLink and updates all of the pointers accordingly 
    	FloorsArrayLink found = search(toRemove.getKey());
    	if (found.getKey() == toRemove.getKey())
    	{
    		updateRemovePointerPrev(toRemove);
    		updateRemovePointerNext(toRemove);
    	}
    }

    public void updateRemovePointerNext(FloorsArrayLink toRemove)
    //updates the all of the right pointers of the removed link
    {
    	int i = 0;	
    	while (i < toRemove.getArrSize()) {
    		toRemove.getPrev(i).setNext(i, toRemove.getNext(i));
    		i = i + 1;
    	}
    }
    
    public void updateRemovePointerPrev(FloorsArrayLink toRemove)
  //updates the all of the left pointers of the removed link
    {
    	int i = 0;	
    	while (i < toRemove.getArrSize()) {
    		toRemove.getNext(i).setPrev(i, toRemove.getPrev(i));
    		i = i + 1;
    	}
    }
    

    
    public FloorsArrayLink lookup(double key) {
    // function that returns the link that it's key equals to key
    	FloorsArrayLink found = search(key);
    	if (found.getKey() == key)
    		return found;
    	return null;
    }

    public double successor(FloorsArrayLink link) { // returns the key after link
        return link.getNext(0).getKey();
    }

    public double predecessor(FloorsArrayLink link) { // returns the key before link
        return link.getPrev(0).getKey();
    }

    public double minimum() { // returns the minimum key
        return first.getNext(0).getKey();
    }

    public double maximum() { // returns the maximum key
    	return last.getPrev(0).getKey();
    }
}
