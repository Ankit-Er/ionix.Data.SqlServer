package ionix.Data.SqlServer;


import ionix.Data.*;

public class EntityCommandDelete<TEntity> extends EntityCommandExecute<TEntity> implements ionix.Data.EntityCommandDelete<TEntity> {

    public EntityCommandDelete(Class<TEntity> entityClass, DbAccess dataAccess) {
        super(entityClass, dataAccess);
    }

    @Override
    public int delete(TEntity entity, EntityMetaDataProvider provider) {
       return this.execute(entity, provider);
    }

    @Override
    public int execute(TEntity entity, EntityMetaDataProvider provider) {

        EntityMetaData metaData = provider.createEntityMetaData(super.getEntityClass());

        SqlQuery q = new SqlQuery("DELETE FROM ").sql(metaData.getTableName());

        q.combine(SqlQueryHelper.createWhereSqlByKeys(metaData, entity));

        return super.getDataAccess().executeUpdate(q,null).getValue();

    }
}
