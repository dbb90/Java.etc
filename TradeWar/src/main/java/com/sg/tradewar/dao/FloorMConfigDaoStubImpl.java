

package com.sg.tradewar.dao;
import com.sg.tradewar.dto.Config;

 

public class FloorMConfigDaoStubImpl implements FloorMConfigDao {


   private Config config;


   public FloorMConfigDaoStubImpl() {
       String type = "Training";
       config = new Config(type);
   }

   

   @Override
   public String getConfig() {
       return config.getType();
   }

 

   @Override

   public void readConfig() throws TradeWarPersistenceException {
  
   }
}