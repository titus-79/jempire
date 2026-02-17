public class Assets {

    int wood;
    int stone;
    int gold;
    int food;
    int citizens;

    public Assets(int wood, int stone, int gold, int food, int citizens) {
        this.wood = wood;
        this.stone = stone;
        this.gold = gold;
        this.food = food;
        this.citizens = citizens;
    }

    public int getWood() {
        return wood;
    }

    public int getStone() {
        return stone;
    }

    public int getGold() {
        return gold;
    }

    public int getFood() {
        return food;
    }

    public int getCitizens() {
        return citizens;
    }

    public void setWood(int newWood) {
        this.wood = newWood;
    }

    public void setStone(int newStone) {
        this.wood = newStone;
    }

    public void setGold(int newGold) {
        this.gold = newGold;
    }

    public void setFood(int newFood) {
        this.food = newFood;
    }

    public void setCitizens(int newCitizens) {
        this.citizens = newCitizens;
    }
    
}
