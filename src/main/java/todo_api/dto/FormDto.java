package todo_api.dto;

public record FormDto(
        String titulo,
        String descricao,
        boolean concluida
) {
}
