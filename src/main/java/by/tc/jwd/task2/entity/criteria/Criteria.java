package by.tc.jwd.task2.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Criteria {

        private Map<SearchCriteria.simpleEquipment, Object> criteria = new HashMap<>();

        public Set<SearchCriteria.simpleEquipment> getKeySet(){
            return criteria.keySet();
        }

        public Object getElement(SearchCriteria.simpleEquipment key){
            return criteria.get(key);
        }

        public void add(SearchCriteria.simpleEquipment searchCriteria, Object value) {
            criteria.put(searchCriteria, value);
        }

}

