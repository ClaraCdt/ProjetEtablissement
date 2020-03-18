package com.fr.adaming.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fr.adaming.dto.NiveauDto;
import com.fr.adaming.entity.Classe;
import com.fr.adaming.entity.Niveau;

@SpringBootTest
public class NiveauConverterTest {

	@Autowired
	public IConverter<Niveau, NiveauDto> convert;

	// Valide !
	@Test
	@DisplayName("Convertion DtoToEntite correct")
	public void testDtoToEntiteValid_shouldReturnEntite() {
		Classe c1 = new Classe();
		Classe c2 = new Classe();
		List<Classe> listClasse = new ArrayList<Classe>();
		listClasse.add(c1);
		listClasse.add(c2);
		NiveauDto dto = new NiveauDto(listClasse, "TopOfTheTop");

		Niveau retour = convert.dtoToEntite(dto);

		assertNotNull(retour);
		assertEquals(listClasse, retour.getClasses());
		assertEquals("TopOfTheTop", retour.getNom());
	}

	// Valide !
	@Test
	@DisplayName("Convertion DtoToEntite avec listNull")
	public void testDtoToEntiteWithNullClasseList_shouldReturnEntite() {
		NiveauDto dto = new NiveauDto(null, "TopOfTheTop");

		Niveau retour = convert.dtoToEntite(dto);

		assertNotNull(retour);
		assertEquals(null, retour.getClasses());
		assertEquals("TopOfTheTop", retour.getNom());
	}

	// Valide !
	@Test
	@DisplayName("Convertion DtoToEntite avec nomNull")
	public void testDtoToEntiteWithNullNom_shouldReturnEntite() {
		Classe c1 = new Classe();
		Classe c2 = new Classe();
		List<Classe> listClasse = new ArrayList<Classe>();
		listClasse.add(c1);
		listClasse.add(c2);
		NiveauDto dto = new NiveauDto(listClasse, null);

		Niveau retour = convert.dtoToEntite(dto);

		assertNotNull(retour);
		assertEquals(listClasse, retour.getClasses());
		assertEquals(null, retour.getNom());
	}

	// Valide !
	@Test
	@DisplayName("Convertion DtoToEntite dtoNull")
	public void testDtoToEntiteWithNullEntite_shouldReturnNull() {
		NiveauDto dto = null;

		Niveau retour = convert.dtoToEntite(dto);

		assertNull(retour);
	}

	// Valide !
	@Test
	@DisplayName("Convertion EntiteToDto correct")
	public void testEntiteToDtoValid_shouldReturnDto() {
		Classe c1 = new Classe();
		Classe c2 = new Classe();
		List<Classe> listClasse = new ArrayList<Classe>();
		listClasse.add(c1);
		listClasse.add(c2);
		Niveau entite = new Niveau(listClasse, 1, "TopOfTheTop");

		NiveauDto retour = convert.entiteToDto(entite);

		assertNotNull(retour);
		assertEquals(listClasse, retour.getClasses());
		assertEquals("TopOfTheTop", retour.getNom());
	}

	// Valide !
	@Test
	@DisplayName("Convertion EntiteToDto avec listNull")
	public void testEntiteToDtoWithNullClasseList_shouldReturnDto() {
		Niveau entite = new Niveau(null, 1, "TopOfTheTop");

		NiveauDto retour = convert.entiteToDto(entite);

		assertNotNull(retour);
		assertEquals(null, retour.getClasses());
		assertEquals("TopOfTheTop", retour.getNom());
	}

	// Valide !
	@Test
	@DisplayName("Convertion EntiteToDto avec nomNull")
	public void testEntiteToDtoWithNullNom_shouldReturnDto() {
		Classe c1 = new Classe();
		Classe c2 = new Classe();
		List<Classe> listClasse = new ArrayList<Classe>();
		listClasse.add(c1);
		listClasse.add(c2);
		Niveau entite = new Niveau(null, 1, "TopOfTheTop");

		NiveauDto retour = convert.entiteToDto(entite);

		assertNotNull(retour);
		assertEquals(listClasse, retour.getClasses());
		assertEquals(null, retour.getNom());
	}

	// Valide !
	@Test
	@DisplayName("Convertion EntiteToDto dtoNull")
	public void testEntiteToDtoWithNullEntite_shouldReturnNull() {
		Niveau entite = null;

		NiveauDto retour = convert.entiteToDto(entite);

		assertNull(retour);
	}

	// Valide !
	@Test
	@DisplayName("Convertion ListDtoToListEntite correct")
	public void testListDtoToListEntiteValid_shouldReturnListEntite() {
		Classe c1 = new Classe();
		Classe c2 = new Classe();
		List<Classe> listClasse = new ArrayList<Classe>();
		listClasse.add(c1);
		listClasse.add(c2);
		NiveauDto dto1 = new NiveauDto(listClasse, "TopOfTheTop");
		NiveauDto dto2 = new NiveauDto(listClasse, "Moins Top");
		List<NiveauDto> listNiveauDto = new ArrayList<NiveauDto>();
		listNiveauDto.add(dto1);
		listNiveauDto.add(dto2);

		List<Niveau> listRetour = convert.listDtoToEntite(listNiveauDto);

		assertNotNull(listRetour);
		assertThat(listRetour).hasSize(2);
		assertThat(listRetour.get(0)).hasFieldOrPropertyWithValue("classes", listClasse);
		assertThat(listRetour.get(0)).hasFieldOrPropertyWithValue("nom", "TopOfTheTop");
	}

	// Valide !
	@Test
	@DisplayName("Convertion ListDtoToListEntite correct")
	public void testListDtoToListEntiteWithNullList_shouldReturnNull() {
		List<NiveauDto> listNiveauDto = null;

		List<Niveau> listRetour = convert.listDtoToEntite(listNiveauDto);

		assertNull(listRetour);
	}

	// Valide !
	@Test
	@DisplayName("Convertion listEntiteToListDto correct")
	public void testListEntiteToListDtoValid_shouldReturnListEntite() {
		Classe c1 = new Classe();
		Classe c2 = new Classe();
		List<Classe> listClasse = new ArrayList<Classe>();
		listClasse.add(c1);
		listClasse.add(c2);
		Niveau entite1 = new Niveau(listClasse, 1, "TopOfTheTop");
		Niveau entite2 = new Niveau(listClasse, 2, "Moins Top");
		List<Niveau> listNiveau = new ArrayList<Niveau>();
		listNiveau.add(entite1);
		listNiveau.add(entite2);

		List<NiveauDto> listRetour = convert.listEntiteToDto(listNiveau);

		assertNotNull(listRetour);
		assertThat(listRetour).hasSize(2);
		assertThat(listRetour.get(0)).hasFieldOrPropertyWithValue("classes", listClasse);
		assertThat(listRetour.get(0)).hasFieldOrPropertyWithValue("nom", "TopOfTheTop");
	}

	// Valide !
	@Test
	@DisplayName("Convertion ListDtoToListEntite null")
	public void testListEntiteToListDtoWithNullList_shouldReturnNull() {
		List<Niveau> listNiveau = null;

		List<NiveauDto> listRetour = convert.listEntiteToDto(listNiveau);

		assertNull(listRetour);
	}
}
