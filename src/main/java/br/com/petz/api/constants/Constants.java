package br.com.petz.api.constants;

public class Constants {
    public static final class Routes {
        private Routes(){}

        public static final String ROUTE_API = "/petz/v1";
        public static final String ROUTE_CLIENT = ROUTE_API + "/client";
        public static final String ROUTE_PET = ROUTE_API + "/pet";
    }

    public static final class Persistencia {
        private Persistencia(){}

        public static final String CLIENT_TABLE = "TB_CLIENT";
        public static final String PET_TABLE = "TB_PET";
    }

    public final class Models {
        public final class Client {

            public final class SerializedAttr {
                private SerializedAttr() {}

                public static final String CLIENT_ID = "CLIENT_ID";
                public static final String NAME = "NAME";

            }
        }

        public final class Pet {

            public final class SerializedAttr {
                private SerializedAttr() {}

                public static final String PET_ID = "PET_ID";
                public static final String NAME = "NAME";
                public static final String PET = "PET";

            }
        }
    }
}
