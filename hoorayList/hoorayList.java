class HoorayList<E> implements CSE11List<E> {

    /* The initial size of elements */
    static final int INIT_ELEM_LEN = 10;

    /* The step size for elements expansion */
    static final int EXPANSION_STEP = 10;

    /*
    * The underlying data structure. The reason this array is of type
    * Object rather than the generic E is because Java does not allow
    * creating generic arrays.
    */
    private Object[] elements;

    /**
    * The size of the array list. This is different from the *capacity*
    * of the list, which is the length of the underlying array `elements`.
    */
    private int size;

    public HoorayList() {
        // TODO
        this.elements = (E[])new Object[INIT_ELEM_LEN];
        this.size = 0; 
        // the constructor okayf
    }

    public int size() {
        return size;    // TODO
    }

    private void expand() {
        // return;      // TODO
        int newCapacity = elements.length + EXPANSION_STEP; 
        Object[] newArray = new Object[newCapacity]; 
        for(int i=0; i < this.elements.length; i++){
            newArray[i] = this.elements[i]; 
    } 
    this.elements = newArray; 
    return;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        // return null; // TODO

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        return (E) elements[index];
        //ensuring type safety 
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        // return null; // TODO

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(index);
        }
        E prevElem = (E)this.elements[index];
        this.elements[index] = element;
        return prevElem;
    }

    public void add(E e) {
        if(size == elements.length){
            expand();
        }
        this.elements[size ++] = e;
        // return;    // TODO
        

    }

    public void add(int index, E element) {
        // return;      // TODO
        // apply the expand command too?
        if (index < 0 || index > size()) { // for some reason >= doesn't work but > does
            throw new IndexOutOfBoundsException(index);
        }

        if(size == elements.length){
            expand(); // making sure we have enough space to add
        }
        // Shifts the element currently at that position (if any) and any
        //* subsequent elements to the right (adds one to their indices).
        for(int i= size; i > index; i--){
            elements[i]=elements[i-1];
        }   
        elements[index] = element; 
        size++; //increasing size of array 
        return;

    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        E removedElem = (E) elements[index];

        // Shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size-1] = null;
        size--;
        return removedElem; // TODO
    }

    public void clear() {
        this.elements = new Object[INIT_ELEM_LEN];
        this.size = 0;

        // this.elements = new Object[0]; naur
            return;      // TODO
    }

    public int indexOf(Object o) {
        for(int i=0; i < elements.length; i++){
            if(elements[i] == o){
                return i; 
            }
        }

        return -1;    // TODO
    }

    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false; // TODO
    }

    public boolean contains(Object o) {
        // if(elements == null){
        //     return false;
        // }

        for(int i=0; i < elements.length; i++){
            if(elements[i] == o ){
                return true; 
            }
        }
        return false; // TODO
    }

    public CSE11List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size) {
            throw new IndexOutOfBoundsException(toIndex); //not sure if that is the right one to add
        }

        if ((fromIndex > toIndex)) {
            throw new IllegalArgumentException();
        }

        HoorayList<E> sublist = new HoorayList<>();
        for(int i= fromIndex; i < toIndex; i++){
            sublist.add(get(i));
        }
        return sublist; // TODO
    }
}