package controller;

import java.util.ArrayList;
import java.util.HashMap;
import model.GradableCategory;
import model.GradableItem;

public interface GradingRubric {
	public HashMap<GradableCategory, ArrayList<GradableItem>> getGradingRubric();
	public HashMap<GradableCategory, ArrayList<GradableItem>> updateGradingRubric(HashMap<GradableCategory, ArrayList<GradableItem>> new_gradingRubric);
}
