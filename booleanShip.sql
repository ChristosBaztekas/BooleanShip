PGDMP         $                 y            booleanship    13.1    13.1 (    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16841    booleanship    DATABASE     o   CREATE DATABASE booleanship WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE booleanship;
                postgres    false            �            1259    17047    auth    TABLE     �   CREATE TABLE public.auth (
    mail character varying,
    sixdigits character varying(6),
    active boolean,
    id integer NOT NULL
);
    DROP TABLE public.auth;
       public         heap    postgres    false            �            1259    17045    auth_id_seq    SEQUENCE     �   CREATE SEQUENCE public.auth_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.auth_id_seq;
       public          postgres    false    208            �           0    0    auth_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.auth_id_seq OWNED BY public.auth.id;
          public          postgres    false    207            �            1259    17019    cases    TABLE     c   CREATE TABLE public.cases (
    afm character varying(9) NOT NULL,
    status character varying
);
    DROP TABLE public.cases;
       public         heap    postgres    false            �            1259    17032    contacts    TABLE     �   CREATE TABLE public.contacts (
    name character varying,
    surname character varying,
    gender character varying,
    c_afm character varying(9) NOT NULL,
    email character varying,
    afm character varying(9)
);
    DROP TABLE public.contacts;
       public         heap    postgres    false            �            1259    16985    humans    TABLE     M  CREATE TABLE public.humans (
    afm character varying NOT NULL,
    ename character varying NOT NULL,
    surname character varying NOT NULL,
    email character varying NOT NULL,
    gender character varying NOT NULL,
    org_type character varying NOT NULL,
    erole character varying NOT NULL,
    org_name character varying
);
    DROP TABLE public.humans;
       public         heap    postgres    false            �            1259    16939    organisations    TABLE     3  CREATE TABLE public.organisations (
    org_id integer NOT NULL,
    org_type character varying NOT NULL,
    org_name character varying NOT NULL,
    org_location character varying NOT NULL,
    org_num_of_people integer NOT NULL,
    username character varying NOT NULL,
    activity character varying
);
 !   DROP TABLE public.organisations;
       public         heap    postgres    false            �            1259    16937    organisations_org_id_seq    SEQUENCE     �   CREATE SEQUENCE public.organisations_org_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.organisations_org_id_seq;
       public          postgres    false    203            �           0    0    organisations_org_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.organisations_org_id_seq OWNED BY public.organisations.org_id;
          public          postgres    false    202            �            1259    16892    users    TABLE     �   CREATE TABLE public.users (
    user_id integer NOT NULL,
    user_type character varying NOT NULL,
    username character varying NOT NULL,
    user_password character varying NOT NULL,
    user_email character varying NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16890    users_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.users_user_id_seq;
       public          postgres    false    201            �           0    0    users_user_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;
          public          postgres    false    200            B           2604    17050    auth id    DEFAULT     b   ALTER TABLE ONLY public.auth ALTER COLUMN id SET DEFAULT nextval('public.auth_id_seq'::regclass);
 6   ALTER TABLE public.auth ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    208    208            A           2604    16942    organisations org_id    DEFAULT     |   ALTER TABLE ONLY public.organisations ALTER COLUMN org_id SET DEFAULT nextval('public.organisations_org_id_seq'::regclass);
 C   ALTER TABLE public.organisations ALTER COLUMN org_id DROP DEFAULT;
       public          postgres    false    203    202    203            @           2604    16895    users user_id    DEFAULT     n   ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);
 <   ALTER TABLE public.users ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    200    201    201            �          0    17047    auth 
   TABLE DATA           ;   COPY public.auth (mail, sixdigits, active, id) FROM stdin;
    public          postgres    false    208   �-       �          0    17019    cases 
   TABLE DATA           ,   COPY public.cases (afm, status) FROM stdin;
    public          postgres    false    205   R/       �          0    17032    contacts 
   TABLE DATA           L   COPY public.contacts (name, surname, gender, c_afm, email, afm) FROM stdin;
    public          postgres    false    206   �/       �          0    16985    humans 
   TABLE DATA           _   COPY public.humans (afm, ename, surname, email, gender, org_type, erole, org_name) FROM stdin;
    public          postgres    false    204   #0       �          0    16939    organisations 
   TABLE DATA           x   COPY public.organisations (org_id, org_type, org_name, org_location, org_num_of_people, username, activity) FROM stdin;
    public          postgres    false    203   �1       �          0    16892    users 
   TABLE DATA           X   COPY public.users (user_id, user_type, username, user_password, user_email) FROM stdin;
    public          postgres    false    201   3       �           0    0    auth_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.auth_id_seq', 40, true);
          public          postgres    false    207            �           0    0    organisations_org_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.organisations_org_id_seq', 16, true);
          public          postgres    false    202            �           0    0    users_user_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.users_user_id_seq', 16, true);
          public          postgres    false    200            R           2606    17055    auth auth_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.auth
    ADD CONSTRAINT auth_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.auth DROP CONSTRAINT auth_pkey;
       public            postgres    false    208            N           2606    17026    cases cases_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.cases
    ADD CONSTRAINT cases_pkey PRIMARY KEY (afm);
 :   ALTER TABLE ONLY public.cases DROP CONSTRAINT cases_pkey;
       public            postgres    false    205            P           2606    17039    contacts contacts_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.contacts
    ADD CONSTRAINT contacts_pkey PRIMARY KEY (c_afm);
 @   ALTER TABLE ONLY public.contacts DROP CONSTRAINT contacts_pkey;
       public            postgres    false    206            L           2606    16992    humans humans_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.humans
    ADD CONSTRAINT humans_pkey PRIMARY KEY (afm);
 <   ALTER TABLE ONLY public.humans DROP CONSTRAINT humans_pkey;
       public            postgres    false    204            H           2606    16949 (   organisations organisations_org_name_key 
   CONSTRAINT     g   ALTER TABLE ONLY public.organisations
    ADD CONSTRAINT organisations_org_name_key UNIQUE (org_name);
 R   ALTER TABLE ONLY public.organisations DROP CONSTRAINT organisations_org_name_key;
       public            postgres    false    203            J           2606    16947     organisations organisations_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.organisations
    ADD CONSTRAINT organisations_pkey PRIMARY KEY (org_id);
 J   ALTER TABLE ONLY public.organisations DROP CONSTRAINT organisations_pkey;
       public            postgres    false    203            D           2606    16900    users users_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    201            F           2606    16902    users users_username_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);
 B   ALTER TABLE ONLY public.users DROP CONSTRAINT users_username_key;
       public            postgres    false    201            U           2606    17027    cases cases_afm_fkey    FK CONSTRAINT     q   ALTER TABLE ONLY public.cases
    ADD CONSTRAINT cases_afm_fkey FOREIGN KEY (afm) REFERENCES public.humans(afm);
 >   ALTER TABLE ONLY public.cases DROP CONSTRAINT cases_afm_fkey;
       public          postgres    false    2892    205    204            V           2606    17040    contacts contacts_afm_fkey    FK CONSTRAINT     w   ALTER TABLE ONLY public.contacts
    ADD CONSTRAINT contacts_afm_fkey FOREIGN KEY (afm) REFERENCES public.humans(afm);
 D   ALTER TABLE ONLY public.contacts DROP CONSTRAINT contacts_afm_fkey;
       public          postgres    false    2892    206    204            S           2606    16950    organisations fk_username    FK CONSTRAINT        ALTER TABLE ONLY public.organisations
    ADD CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES public.users(username);
 C   ALTER TABLE ONLY public.organisations DROP CONSTRAINT fk_username;
       public          postgres    false    203    2886    201            T           2606    16993    humans humans_org_name_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.humans
    ADD CONSTRAINT humans_org_name_fkey FOREIGN KEY (org_name) REFERENCES public.organisations(org_name);
 E   ALTER TABLE ONLY public.humans DROP CONSTRAINT humans_org_name_fkey;
       public          postgres    false    204    203    2888            �   �  x���Mn�0F��a��!g�;�9@7L��jdI���C2@!�� �����a'^5bw��%�{��k�ï�ڱ@����y� ��"�o@�g�J���x���<i���_��үs�紲n+���U��s�Oi=��J ��"��?�D�c��Y,����4�^6H9*`E��i��q?���1���t�p;��k��s�7L��z�\�PG���|���mtD-=�!������P�T@귄hQ���\L5��[d����Dו�V���49�륟�� L������5��3]�!}��~=�M�ij?\@�����t��x���}�K�E������cj4k�C{fbIXM�c�	�iP�3A�mɎI&F���^w-��M���+�~���n ^��a�3M�Z��cF��c���~�s�$knS      �   E   x�34526731���/�,�,K�24���4375A216��!	�����X 	�XZ��#�b���� U��      �   l   x�H,��/��H�I,�,��M�I�4412653�0��H�	pH�M���K���44���4375�r�I����M,��/�LK�h36��0731��A�:��YZ��s��qqq Ti"      �   _  x����n�0���S�	���`�`��]LkJDWi�Է�˦m�I�)�%����82�AҲ�N<Kh@[j�W�	�կ����ޢn@�YI�h@�8hyE�I;���+�V,�'��8������F�Ͻ���#�jZE�x1P*t�$�2F�b�PK��-h����E9፳��O�nN��rh��-��dה�3��dj�+���al�����n5�8͢��Q��GR��\p&���oMU�q_���H�a0F�,Z�n�_X��g=a?�������.
��i��,�N\�g�N�L�����Z��7�~�^Yh\�ǜ�x9�(���#a_rt��# w=4:In�@���� �e�u      �   d  x���Mn�0�דS��Bt�
J� �n�d �'�O�ܾN�T�ll���<��D�w�uْD��nء�9BbKTf�CR���+2X�3ivqh�	��i��<�I8HV�K�,��N%2#��V��|�Vn�0�)cyVaÆ~P+���f��>xn�kT�F�*�U���O�o��;�ƪ@øF��̬�Q�#���]W��yITALlUJ��J,��$��z��K�E3�4��ڳ��&Cg;���CD°�Z;MW��	o'��n�"b�F*n�j��/m���|�N�0�Rߟ�d�+/H�����`�g���ڏ���'��XrL�-ϑ����Yq�}'����.�<�����/� .+      �   U  x�}R�n�0</�n9DMQT�ʭ�����"����&$q��l�����-��&'NZ0��
�@=��,H�DQl$?�[�BnRQ-&n�f���P��B�e���Mk�ޛ�HBN�NA�m�Bʜ��jA�Ɛ��$����K���<���}%š�8q}�d�.��[�-�i�d3����L�6���n<�㬖lLJF��mV��,,D#^�/���\�i'!k��M�fW�'�����<��k8(YK棡��!�X�|���vt�l�ծ��v��9�EЊ��o_��$b����l��p�
�Ϣ�Y���|Q�%~&�~F����cE�� �     