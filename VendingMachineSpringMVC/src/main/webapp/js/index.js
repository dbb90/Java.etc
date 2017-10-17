$("Document").ready(function () {

    $("#returnChange").click(function () {
        $("#changeOut").val("");
        var total = parseFloat($("#moneyIn").val());

        total = parseInt(total * 100);

        var quarters = Math.floor(total / 25);

        total = total % 25;

        var dimes = Math.floor(total / 10);

        total = total % 10;

        var nickels = Math.floor(total / 5);

        var pennies = total % 5;



        if (!(quarters === 0)) {
            if (quarters === 1) {
                var quartersyntax = " Quarter "
            } else {
                var quartersyntax = " Quarters "
            }

            var output = $("#changeOut").val();
            output = output + quarters + " " + quartersyntax + " ";
            $("#changeOut").val(output);
        }

        if (!(dimes === 0)) {
            if (dimes === 1) {
                var syntax = " Dime "
            } else {
                var syntax = " Dimes "
            }

            var output = $("#changeOut").val();
            output = output + dimes + " " + syntax + " ";
            $("#changeOut").val(output);
        }

        if (!(nickels === 0)) {
            if (nickels === 1) {
                var syntax = " Nickel "
            } else {
                var syntax = " Nickels "
            }

            var output = $("#changeOut").val();
            output = output + nickels + " " + syntax + " ";
            $("#changeOut").val(output);
        }

        if (!(pennies === 0)) {
            if (pennies === 1) {
                var syntax = " A Lonely Penny "
            } else {
                var syntax = " Pennies "
            }

            var output = $("#changeOut").val();
            output = output + pennies + " " + syntax + " ";
            $("#changeOut").val(output);
        }

        $("#moneyIn").val(0.00);

    });
});

    $("#addDime").click(function () {
        var userBalance = parseFloat($("#moneyIn").val());
        userBalance = (userBalance + 0.10);
        $("#moneyIn").val(userBalance.toFixed(2));
    });

    $("#addNickel").click(function () {
        var userBalance = parseFloat($("#moneyIn").val());
        userBalance = (userBalance + 0.05);
        $("#moneyIn").val(userBalance.toFixed(2));
    });

    $("#addQuarter").click(function () {
        var userBalance = parseFloat($("#moneyIn").val());
        userBalance = (userBalance + 0.25);
        $("#moneyIn").val(userBalance.toFixed(2));
    });

    $("#addDollar").click(function () {
        var userBalance = parseFloat($("#moneyIn").val());
        var userBalance = (userBalance + 1);
        $("#moneyIn").val(userBalance.toFixed(2));
    });


function displayItem(id) {
  $("#itemOut").val(id);
}

//function purchaseItem (id, money) {
//      $("#messageOut").val("Thank You!!!");
//      $("#itemOut").empty();
//      $("#moneyIn").val(0.00);
//      $("itemsDiv").empty();
//
//
//      $("#changeOut").val("");
//      var quarters = parseInt(data.quarters);
//      var dimes = parseInt(data.dimes);
//      var nickels = parseInt(data.nickels);
//      var pennies = parseInt(data.pennies);
//
//
//      if (!(id.quarters === 0)) {
//        if (id.quarters === 1) {
//          var quartersyntax = " Quarter "
//        } else {
//          var quartersyntax = " Quarters "
//        }
//
//        var output = $("#changeOut").val();
//        output = output + quarters + " " + quartersyntax + " ";
//        $("#changeOut").val(output);
//
//      }
//
//
//      if (!(dimes === 0)) {
//        if (dimes === 1) {
//          var syntax = " Dime "
//        } else {
//          var syntax = " Dimes "
//        }
//
//        var output = $("#changeOut").val();
//        output = output + dimes + " " + syntax + " ";
//        $("#changeOut").val(output);
//      }
//
//      if (!(nickels === 0)) {
//        if (nickels === 1) {
//          var syntax = " Nickel "
//        } else {
//          var syntax = " Nickels "
//        }
//
//        var output = $("#changeOut").val();
//        output = output + nickels + " " + syntax + " ";
//        $("#changeOut").val(output);
//      }
//
//      if (!(pennies === 0)) {
//        if (pennies === 1) {
//          var syntax = " A Lonely Penny "
//        } else {
//          var syntax = " Pennies "
//        }
//
//        var output = $("#changeOut").val();
//        output = output + pennies + " " + syntax + " ";
//        $("#changeOut").val(output);
//      }
//
//
//
//
//    },
//    error: function(error) {
//      console.error("failure!");
//    }
//  });
//});