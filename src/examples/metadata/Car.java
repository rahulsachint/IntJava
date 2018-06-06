package examples.metadata;

import java.util.List;


public class Car
{
	@NotNull
	@Length(min=10)
    private String modelName;

    private int numWheels;
    
    private int numDoors;

    public String getModelName ()
    {
        return modelName;
    }

    public void setModelName (String modelName)
    {
        this.modelName = modelName;
    }

    public int getNumWheels ()
    {
        return numWheels;
    }

    public void setNumWheels (int numWheels)
    {
        this.numWheels = numWheels;
    }

    public int getNumDoors ()
    {
        return numDoors;
    }

    public void setNumDoors (int numDoors)
    {
        this.numDoors = numDoors;
    }

    @Override
	public String toString() {
		return "Car [modelName=" + modelName + ", numWheels=" + numWheels
				+ ", numDoors=" + numDoors + "]";
	}
    
    
}
