# En PC nueva

# Generar nueva key
Con el siguiente comando generamos una nueva KEY, acordarse de la passphrase porque se usará más adelante
```
gpg --gen-key
```
Si obtenemos errores similares a "window too small correr"
```
gpgconf --kill gpg-agent
gpgconf --launch gpg-agent      
```

# Obtenemos la key
Usemos alguno de estos 2 comandos
```
gpg --list-keys
gpg --list-secret-keys --keyid-format LONG
```

se obtendrá algo como esto
```
pub   ed25519 2025-03-29 [SC] [expires: 2028-03-28]
E69604A2F5C81BB959C5A8A22ABEF510FA47C0F3
uid           [ultimate] Jean Paul Perea <jeanpaper@gmail.com>
sub   cv25519 2025-03-29 [E] [expires: 2028-03-28]
```

# Insertar datos en gradle.properties
Editar o crear el archivo ubicado en el home del usuario
```
~/.gradle/gradle.properties
```
El keyId es la última parte del pub en el resultado de gpg --list-keys.
```
E69604A2F5C81BB959C5A8A22ABEF510FA47C0F3
```

El keyId es FA47C0F3 (los últimos 8 caracteres). Entonces, en local.properties:
```
signing.keyId=FA47C0F3
```

Gradle requiere un archivo .gpg con tu clave secreta. Genera el archivo con (pedirá la passphrase):
```
gpg --export-secret-keys --output ~/secring.gpg FA47C0F3
```
Se habrá creado en la carpeta del usuario, por ejemplo
```
signing.secretKeyRingFile=/Users/jean.perea/secring.gpg
```
Por último poner la passphrase
```
signing.password=TU_CONTRASEÑA
```
Debería quedar similar a
```
mavenCentralUsername=username
mavenCentralPassword=the_password

signing.keyId=FA47C0F3
signing.password=some_password
signing.secretKeyRingFile=/Users/yourusername/.gnupg/secring.gpg
```


# Para publicar

PRIMERO: Cambiar versión en el build.gradle 

Luego correr los siguientes scripts:
```
./gradlew publishToMavenCentral --no-configuration-cache
./gradlew publishAndReleaseToMavenCentral --no-configuration-cache
```


# Mas info
https://vanniktech.github.io/gradle-maven-publish-plugin/central/