package controller;

import java.util.ArrayList;
import model.Database;
import model.GradableCategory;
import model.GradableItem;

public class CourseLogisticController extends CategoryInformationController implements CourseLogistic{
	
	public CourseLogisticController(int courseId) {
		super(courseId);
	}

	@Override
	public ArrayList<GradableItem> getAllGradedItems(int courseId) {
		ArrayList<GradableCategory> list_of_gradable_categories = Database.getCategoriesInCourse(courseId);
		ArrayList<GradableItem> list_of_gradable_items = new ArrayList<GradableItem>();
		
		for(GradableCategory gc : list_of_gradable_categories)
		{
			ArrayList<GradableItem> list = Database.getGradedItemsInCategory(gc.getId());
			for(GradableItem gi : list)
			{
				list_of_gradable_items.add(gi);
			}
		}
		return list_of_gradable_items;
	}
	

	@Override
	public boolean isInclude(int gradedItemId) {
		boolean flag = Database.checkIfIncludedGradedItem(gradedItemId);
		return flag;
	}

	@Override
	public void setInclude(int gradedItemId) {
		Database.setIncludeGradedItem(gradedItemId);
	}

	@Override
	public void setExclude(int gradedItemId) {
		Database.setExcludeGradedItem(gradedItemId);
	}

	@Override
	public void setDelete(int gradedItemId) {
		Database.setDeleteGradedItem(gradedItemId);
	}

}
