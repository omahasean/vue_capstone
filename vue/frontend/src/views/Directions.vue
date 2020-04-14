<template>
    <div id="directions">
      <ul>
          <option v-for="(direction,index) in newRoutes" :key="index">
          <li>{{direction}}</li>
          </option>

          <!-- <option v-for="(direction,index) in directions" :key="index">
          <li>{{direction.instruction.text}}</li>
          </option> -->
          
          <!-- <option v-for="(direction,index) in subLegs" :key="index">
          <li>{{direction.instruction.text}}</li>
          </option> -->
      </ul>
    </div>
</template>

<script>
export default {
    name: 'Directions',

    props: {
        wp: String
    },

    data() {
        return {
            routeInfo: '',
            directions: [],
            subLegs: [],
            routeLegs: [],
            newRoutes:[],
            itineraryRoutes: []
        }
    },

    // computed: {
    //     getRoutes() {
    //        return this.routeLegs.map((e) => {
    //             return e.itineraryItems.forEach((route) => {
    //                return route.instruction.text;
    //            });
    //        });
    //     }
    // },


    beforeMount() {
        fetch(`http://dev.virtualearth.net/REST/v1/Routes/Driving?${this.wp}&o=json&key=AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m`, {
            method: 'GET',

            headers: {
                Accept: 'application/json'
            }
        })
        .then((response) => {
           return response.json()
        })
        .then((json) => {
           
           
           //console.log(this.newRoutes)
            // this.routeLegs = this.newRoutes.map((routeObject) => {
            //     routeObject.itineraryItems.forEach((direction) => {
            //         console.log(direction.instuction.text);
            //     })
            // });

            // console.log(this.routeLegs)

            let numberOfStops = json.resourceSets[0].resources[0].routeLegs.length;
            this.newRoutes = []
            for(let i = 0; i < numberOfStops; i++){
                
                json.resourceSets[0].resources[0].routeLegs[i].itineraryItems.forEach((item) => {
                    this.newRoutes.push(item.instruction.text);
                });
            }

            // console.log(this.newRoutes);
            // this.directions = json.resourceSets[0].resources[0].routeLegs[0].itineraryItems;
            // this.subLegs = json.resourceSets[0].resources[0].routeLegs[1].itineraryItems;
            
        })
       .catch((err) => console.log(err));
    },

    

}
</script>

<style>
#directions {
    color: white;
    
}

</style>