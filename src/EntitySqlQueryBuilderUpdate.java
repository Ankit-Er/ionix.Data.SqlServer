import ionix.Data.EntityMetaData;
import ionix.Data.EntitySqlQueryBuilder;
import ionix.Data.SqlQuery;

import java.util.HashSet;


public class EntitySqlQueryBuilderUpdate implements EntitySqlQueryBuilder {

    private HashSet<String> updatedFields;
    public HashSet<String> getUpdatedFields(){
        return this.updatedFields;
    }
    public void setUpdatedFields(HashSet<String> updatedFields){
        this.updatedFields = updatedFields;
    }

    @Override
    public SqlQuery createQuery(Object entity, EntityMetaData entityMetaData) {
       if (null == entity)
           throw new IllegalArgumentException("entity is null");

        return null;
    }
}
