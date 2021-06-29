/**
 * @param {number} n
 * @param {number[][]} entries
 */
var MovieRentingSystem = function(n, entries) {
    this.n = n;
    this.entries = entries;

    this.hasRent = [];
    this.entries.sort((x,y) => {
        let priceDiff = x[2]-y[2];
        if(priceDiff === 0) return x[0] - y[0];
        return priceDiff;
    });
    this.hasNotEntries = Array.from(this.entries);
};

/**
 * @param {number} movie
 * @return {number[]}
 */
MovieRentingSystem.prototype.search = function(movie) {
    let hasMovie = [];
    for(let i = 0; i < this.hasNotEntries.length; i++){
        let entry = this.hasNotEntries[i];
        if(entry[1] === movie && !this.hasRent.some(rent => rent[0] == entry[0] && rent[1] == entry[1])){
            hasMovie.push(entry);
        }
        if(hasMovie.length >= 5)break;

    }
    return hasMovie.map(x=>x[0]);
};

/**
 * @param {number} shop
 * @param {number} movie
 * @return {void}
 */
MovieRentingSystem.prototype.rent = function(shop, movie) {
    let entryIndex = this.hasNotEntries.findIndex((e)=>e[0]===shop && e[1] === movie);
    let entry = this.hasNotEntries[entryIndex];
    this.hasNotEntries.splice(entryIndex,1);
    this.hasRent.push([shop,movie,entry[2]]);
    this.hasRent.sort((x,y)=>{
        let priceDiff = x[2]-y[2];
        if(priceDiff === 0) {
           let store = x[0] - y[0]
           if(store === 0){
               return x[1] - y[1];
           }
            return store;
        };
        return priceDiff;
    });
};

/**
 * @param {number} shop
 * @param {number} movie
 * @return {void}
 */
MovieRentingSystem.prototype.drop = function(shop, movie) {
    for(let i = 0; i < this.hasRent.length; i++){
        if(this.hasRent[i][0] === shop && this.hasRent[i][1] === movie){
            this.hasNotEntries.push([this.hasRent[i][0],this.hasRent[i][1],this.hasRent[i][2]]);
            this.hasRent.splice(i,1);
            break;
        }
    }
     this.hasNotEntries.sort((x,y)=>{
        let priceDiff = x[2]-y[2];
        if(priceDiff === 0) {
           let store = x[0] - y[0]
            return store;
        };
        return priceDiff;
    });
};

/**
 * @return {number[][]}
 */
MovieRentingSystem.prototype.report = function() {
    let newArray = Array.from(this.hasRent);

    if(newArray.length > 5){
        newArray = newArray.slice(0,5);
    }
    return newArray.map(x=>[x[0],x[1]]);
};

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * var obj = new MovieRentingSystem(n, entries)
 * var param_1 = obj.search(movie)
 * obj.rent(shop,movie)
 * obj.drop(shop,movie)
 * var param_4 = obj.report()
 */
