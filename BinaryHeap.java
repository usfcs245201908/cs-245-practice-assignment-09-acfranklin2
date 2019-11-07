
public class BinaryHeap
{
	int[] data;
	int size;

	public BinaryHeap()
	{
		data = new int[10];
		size = 0;
	}

	public void growArray()
	{
		int[] newArray = new int[data.length * 2];
		for(int i = 0; i < size; i++)
			newArray[i] = data[i];
		data = newArray;
	}

	public void add(int priority)
	{
		if(size == data.length)
			growArray();
		data[size++] = priority;
		int child = size - 1;
		int parent = (child - 1)/2;
		while((parent >= 0) && (data[parent] > data[child])) {
			swap(parent, child);
			child = parent;
			parent = (child - 1)/2;
		}
	}

	public int remove()
	{
		try{
			if(size == 0)
				throw new Exception("This array is empty.");
		}
		catch(Exception e){};
		int temp = data[0];
		data[0] = data[--size];
		siftdown(0);
		return(temp);
	}

	public void siftdown(int place)
	{
		int child = place*2 + 1;
		if((child < size) && (data[child + 1] < data[child]))
			child++;
		if((child < size) && (data[place] > data[child])) {
			swap(place, child);
			//Checks if there even is a child to the child that can be sifted down
			if(child*2+1 < size)
				siftdown(child);
		}
	}

	public void swap(int parent, int child)
	{
		int temp = data[parent];
		data[parent] = data[child];
		data[child] = temp;
	}
}

/*
                 7
        33                93
   58       11         1     38
 8   31  33  52     59    31  30
2 5 6 4 9 51 64 28 35 69 13 100 */