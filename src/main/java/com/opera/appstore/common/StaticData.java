package com.opera.appstore.common;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
public class StaticData {

    public final static Long TIMEOUT = 60L;


    public enum TypeValues {
        COMMERCIAL("Commercial (Buy only)"),
        SHAREWARE("Shareware (Try and Buy)"),
        FREEWARE("Freeware (Free)");

        private final String text;

        private TypeValues(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public enum PlatformValues {
        WINDOWS_MOBILE("Windows Mobile"),
        ANDROID("Android");
        //todo TBD add remaining values
        private final String text;

        private PlatformValues(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public enum InstallerTypeValues {
        DEVICE_INSTALLER("Device installer"),
        EBOOK("eBook");
        //todo TBD add remaining values
        private final String text;

        private InstallerTypeValues(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public enum VersionsValues {
        FULL("Full"),
        DEMO("Demo"),
        TRIAL("Trial");

        private final String text;

        private VersionsValues(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public enum UploadType {
        IMAGE, THUMBNAIL, APK;
    }


}
