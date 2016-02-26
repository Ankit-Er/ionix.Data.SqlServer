package ionix.Data.SqlServer;

import ionix.Data.DbAccess;
import ionix.Data.EntityCommandExecute;
import ionix.Data.EntityMetaDataProvider;
import ionix.Data.SqlQuery;

import java.util.HashSet;


public class EntityCommandUpdate extends EntityCommandExecute implements ionix.Data.EntityCommandUpdate {

    public EntityCommandUpdate(DbAccess dataAccess, Class<?> entityClass){
        super(dataAccess, entityClass);
    }


    @Override
    public <TEntity> int execute(TEntity entity, EntityMetaDataProvider provider) {
        EntitySqlQueryBuilderUpdate builder = new EntitySqlQueryBuilderUpdate();
        builder.setUpdatedFields(this.getUpdatedFields());

        SqlQuery query = builder.createQuery(entity, provider.createEntityMetaData(this.getEntityClass()));
        return this.getDataAccess().executeUpdate(query);
    }

    private HashSet<String> updatedFields;
    @Override
    public HashSet<String> getUpdatedFields() {
        return this.updatedFields;
    }
    @Override
    public void setUpdatedFields(HashSet<String> updatedFields) {
        this.updatedFields = updatedFields;
    }

    @Override
    public <TEntity> int update(TEntity entity, EntityMetaDataProvider provider) {
        return this.execute(entity, provider);
    }
}
