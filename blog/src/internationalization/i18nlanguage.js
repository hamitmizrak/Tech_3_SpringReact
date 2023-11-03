import i18n from 'i18next';
import {initReactI18next} from 'react-i18next';

i18n.use(initReactI18next).init({
    resources: {
        en:
            {
                translations: {
                    'registers': 'Registers',
                    'register': 'Register',
                    'register_list': 'Register List',
                    'register_create': 'Register Create',
                    'register_delete': 'Register Delete',
                    'register_update': 'Register Update',
                    'register_show': 'Register Show',
                    'create_all': 'Create All',
                    'delete_all': 'Delete All',
                    'create': 'Create',
                    'delete': 'Delete',
                    'update': 'Update',
                    'cleaner': 'Cleaner',
                    'submit': 'Submit',
                    'system_date':"System Date",
                    'show': 'Show',
                    'login': 'Login',
                    'home': "Home",
                    'search': "search",
                    'all_rights_reserved':"All Rights Reserved",
                    'id':"ID",
                    'user_nickname':"Nick name",
                    'user_name':"User Name",
                    'user_surname':"User Surname",
                    'user_password':"User Password",
                    'user_email':"User Email",
                    'user_is_passive':"User Passive",
                    'is_read': 'Is Read ?',
                    'language':'Language'
                }
            },
        tr:
            {
                translations: {
                    'registers': 'Üyeler',
                    'register': 'Üye Kayıt',
                    'register_list': 'Üyeleri Liste',
                    'register_create': 'Üye Ekle',
                    'register_delete': 'Üye Sil',
                    'register_update': 'Üye Güncelle',
                    'register_show': 'Üye Göster',
                    'create_all': 'Veri Ekle',
                    'delete_all': 'Bütün Verileri Sil',
                    'create': 'Ekle',
                    'delete': 'Sil',
                    'update': 'Güncelle',
                    'cleaner': 'Temizle',
                    'submit': 'Gönder',
                    'system_date':"Ekleme Tarihi",
                    'show': 'Göster',
                    'login': 'Giriş',
                    'home': "Anasayfa",
                    'search': "Arama",
                    'all_rights_reserved':"Bütün Haklar Saklıdır",
                    'id':"ID",
                    'user_nickname':"Takma Adı",
                    'user_name':"Adınız",
                    'user_surname':"soyadınız",
                    'user_password':"Şifreniz",
                    'user_email':"Emailiniz",
                    'user_is_passive':"Aktif mi ?",
                    'is_read': 'Okudunuz mu ?',
                    'language':'Diller'
                }
            }
    },
    fallbackLng: 'tr',    //fallbackLng: 'en', fall back function    
    ns: ['translations'], //kelimeleri nerede alsın
    defaultNS: 'translations',
    keySeparator: false,
    interpolation: {escapeValue: false, formatSeparator: ','},
    react: {
        wait: true
    }
});
export default i18n;