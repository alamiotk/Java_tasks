public enum ItemCondition {                                                     // tryb wyliczeniowy: ENUM
    NEW {
        @Override public String toString(){     // konwersja na String
            return "NEW";
        }                    // konwersja na String
    },

    USED{
        @Override public String toString(){
            return "USED";
        }
    },

    REFURBISHED{
        @Override public String toString(){
            return "REFURBISHED";
        }
    };
}