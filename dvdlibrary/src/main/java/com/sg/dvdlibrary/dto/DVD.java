

/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

package com.sg.dvdlibrary.dto;

 

/**

 *

 * @author dbb09-

 */

public class DVD {

   

   private String title;

   private String releaseYear;

   private String mpaa;

   private String director;

   private String studio;

   private String rating;

   

   public DVD(String title){

       this.title = title;

   }

   

   

   public String getTitle() {

       return title;

   }

   

   public void setTitle(String title) {

       this.title = title;

   }

 

   public String getReleaseYear() {

       return releaseYear;

   }

 

   public void setReleaseYear(String releaseYear) {

       this.releaseYear = releaseYear;

   }

 

   public String getMpaa() {

       return mpaa;

   }

 

   public void setMpaa(String mpaa) {

       this.mpaa = mpaa;

   }

 

   public String getDirector() {

       return director;

   }

 

   public void setDirector(String director) {

       this.director = director;

   }

 

   public String getStudio() {

       return studio;

   }

 

   public void setStudio(String studio) {

       this.studio = studio;

   }

 

   public String getRating() {

       return rating;

   }

 

   public void setRating(String rating) {

       this.rating = rating;

   }

   

   

}

