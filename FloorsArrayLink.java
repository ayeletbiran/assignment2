public class FloorsArrayLink {
    //@TODO: add fields
	private double key;
	private int arrsize;
	private FloorsArrayLink[] arrfront;
	private FloorsArrayLink[] arrback;	

    public FloorsArrayLink(double key, int arrSize){
    	this.key=key;
    	this.arrsize=arrSize;
    	this.arrfront=new FloorsArrayLink[arrsize];
    	this.arrback=new FloorsArrayLink[arrsize];

    }

    public double getKey() {
    	return this.key;
    }

    public FloorsArrayLink getNext(int i) {
    	if(i<=arrsize)
    		return this.arrfront[i-1];
    	return null;
    }

    public FloorsArrayLink getPrev(int i) {
    	if(i<=arrsize)
    		return this.arrback[i-1];
    	return null;
    }

    public void setNext(int i, FloorsArrayLink next) {
    	if(i<=arrsize) {
    		this.arrfront[i-1]=next;
    	}
    }

    public void setPrev(int i, FloorsArrayLink prev) {
    	if(i<=arrsize) {
    		this.arrback[i-1]=prev;
    	}    
    	
    }

    public int getArrSize(){
        return this.arrsize;
    }
}

