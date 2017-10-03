$(document).ready(function() {

      loadItems();

      $.ajax({
        // properties in our parameter object, which is an object literal w/ key/value pairs
        type: "GET",
        url: "http://localhost:8080/items",

        //success is the callback function we want to run when the Ajax call has
        //been completed successfully
        success: function(itemsArray) {

          //get a reference to the 'allContacts' div
          var itemsDiv = $("#allItems");

          //essentially the same as an enhanced for loop (forEach)
          //go thru each contact in result and append its info to the contactsDiv
          //we take the next contact out of contactArray and pass it into
          // the function for processing, and so on until there are no
          // more contacts to process.
          $.each(itemArray, function(index, item) {
            var itemInfo = "<p>";
            var id = item.id;
            var name = item.name;
            var price = item.price;
            var quantity = item.quantity;
            //building an HTML paragraph element (var contactInfo)
            itemInfo += "ID:" item.id "<br />";
            itemInfo += "Name:" item.name "<br />";
            itemInfo += "Price:" + item.price + "<br />";
            contactInfo += "Quantity:" + item.quantity + "<br />";

            //We append the HTML paragraph element to the allContacts div.
            itemsDiv.append(iteminfo);

          });



        },
        error: function() {
          alert("FAILURE!");
        }




      });
