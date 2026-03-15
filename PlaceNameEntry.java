public class PlaceNameEntry {
   public int id;
   public String placeName;
   public String municipality;
   public String province;
   public String population;
   
   public PlaceNameEntry () {
      this.id = id;
      this.placeName = placeName;
      this.municipality = municipality;
      this.province = province;
      this.population = population;
   }
   
   public PlaceNameEntry (int id, String placeName, String municipality, String province, String population) {
      this.id = id;
      this.placeName = placeName;
      this.municipality = municipality;
      this.province = province;
      this.population = population;
   }
   
   public String getPlaceName () {
      return placeName;
   }
   
   public String getMunicipality () {
      return municipality;
   }
   
   public String getProvince () {
      return province;
   }
   
   public String getPopulation () {
      return population;
   }
   
   public String toString() {
      return id+","+placeName+","+municipality+","+province+","+population;
   }
   
}
   
   