package controller;

import java.util.List;

public interface CourseLogistic {
	public List<Integer> getAllGradedItems();
	public float getMean(int gradedItemId);
	public float getStandardDeviation(int gradedItemId);
	public boolean isInclude(int gradedItemId);
	public void setInclude(int gradedItemId);
	public void setExclude(int gradedItemId);
	public void setDelete(int gradedItemId);
}
