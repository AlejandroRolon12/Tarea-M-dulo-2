Descripción
El Gestor de Usuarios permite:
- Introducir y editar información de usuarios (nombre, email, rol, estado activo y notas).
- Visualizar un resumen de los datos ingresados.
- Registrar acciones en un panel de logs.
- Confirmar operaciones importantes mediante un diálogo de confirmación.
- Limpiar el formulario o cancelar la operación de manera segura.
Está diseñado con Java Swing y utiliza un enfoque modular con ventanas principales (JFrame) y diálogos personalizados (JDialog).

Funcionalidades principales
- Formulario de usuario: nombre, email, rol (Admin, Editor, Invitado), activo y notas.
- Panel de navegación: botones para futuras secciones (Dashboard, Usuarios, Informes, Ajustes, Ayuda).
- Resumen en tiempo real: muestra los datos ingresados en un JTextArea.
- Registro de logs: historial de acciones realizadas dentro de la aplicación.
- Diálogo de confirmación: confirma si se desea guardar los cambios.
- Botones de acción:
a) Guardar: guarda los datos (simulado) y genera un log.
b) Limpiar: resetea todos los campos del formulario.
c) Cancelar: cierra la aplicación con confirmación.

Estructura del proyecto
- Java 8 o superior.
- IDE recomendado: Eclipse, IntelliJ IDEA o cualquier IDE compatible con Java Swing.
- No requiere librerías externas.

Ejecución
1)Clonar o descargar el proyecto.
2)Abrir en tu IDE favorito.
3)Ejecutar la clase GestorUsuarios como aplicación Java (main).
4)Interactuar con la interfaz para agregar, limpiar o guardar usuarios.

Notas adicionales
- Los datos no se guardan realmente en una base de datos; el guardado está simulado y registrado en el panel de logs.
- El diseño utiliza GridBagLayout y paneles laterales para una estructura flexible.
- El proyecto es fácilmente extensible para agregar nuevas funcionalidades, como integración con base de datos o exportación de datos.
