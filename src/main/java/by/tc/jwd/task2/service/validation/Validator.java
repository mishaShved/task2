package by.tc.jwd.task2.service.validation;

import by.tc.jwd.task2.entity.criteria.Category;
import by.tc.jwd.task2.entity.criteria.Criteria;
import by.tc.jwd.task2.entity.criteria.SearchCriteria;

public class Validator {

    public static boolean criteriaValidator(Criteria criteria) {

        boolean isValid = true;
        for (SearchCriteria.simpleEquipment element : criteria.getKeySet()) {
            if (element == SearchCriteria.simpleEquipment.CATEGORY) {
                if (!(criteria.getElement(element) instanceof Category)) {
                    isValid = false;
                    break;
                }
            }else if(element == SearchCriteria.simpleEquipment.TITLE){
                if (!(criteria.getElement(element) instanceof CharSequence)) {
                    isValid = false;
                    break;
                }
            }else if(element == SearchCriteria.simpleEquipment.PRICE){
                if (!(criteria.getElement(element) instanceof Integer)) {
                    isValid = false;
                    break;
                }
            }

        }
        return isValid;
    }
}
