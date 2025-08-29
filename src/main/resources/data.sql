TRUNCATE TABLE wind_direction RESTART IDENTITY CASCADE;
TRUNCATE TABLE track_status RESTART IDENTITY CASCADE;
TRUNCATE TABLE compound RESTART IDENTITY CASCADE;
TRUNCATE TABLE drs RESTART IDENTITY CASCADE;
TRUNCATE TABLE event_round RESTART IDENTITY CASCADE;
TRUNCATE TABLE sessions RESTART IDENTITY CASCADE;
TRUNCATE TABLE driver RESTART IDENTITY CASCADE;
TRUNCATE TABLE team RESTART IDENTITY CASCADE;
TRUNCATE TABLE dta RESTART IDENTITY CASCADE;

INSERT INTO event_round (event_round_id, year, round_number, country, location, event_name, event_date, sprint_event, soft, medium, hard)
VALUES (1, 2025, 1, 'Australia', 'Melbourne', 'Australian Grand Prix', '2025-05-16T15:15:00Z', 'false', '5', '4', '3');

INSERT INTO sessions (session_id, event_round_id, session_date, session_name) VALUES (1, 1, '2025-05-16T15:15:00Z', 'Race');

INSERT INTO driver (driver_id, driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (1, 16, 'LEC', 'Charles Leclerc', '#666999', 'MC');

INSERT INTO team (team_id, team_name, team_hex_color) VALUES (1, 'Ferrari', '#999666');

INSERT INTO dta(dta_id, session_id, driver_id, team_id) VALUES (1, 1,1,1);

INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (1, 'N');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (2, 'NNE');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (3, 'NE');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (4, 'ENE');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (5, 'E');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (6, 'ESE');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (7, 'SE');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (8, 'SSE');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (9, 'S');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (10, 'SSW');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (11, 'SW');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (12, 'WSW');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (13, 'W');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (14, 'WNW');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (15, 'NW');
INSERT INTO wind_direction (wind_direction_id, cardinal_direction) VALUES (16, 'NNW');

INSERT INTO track_status (track_status_id, track_state) VALUES (1, 'TrackClear');
INSERT INTO track_status (track_status_id, track_state) VALUES (2, 'Yellow flag');
INSERT INTO track_status (track_status_id, track_state) VALUES (3, 'Unknown');
INSERT INTO track_status (track_status_id, track_state) VALUES (4, 'Safety Car');
INSERT INTO track_status (track_status_id, track_state) VALUES (5, 'Red Flag');
INSERT INTO track_status (track_status_id, track_state) VALUES (6, 'VSC deployed');
INSERT INTO track_status (track_status_id, track_state) VALUES (7, 'VSC ending');

INSERT INTO compound (compound_id, compound_name) VALUES (1, 'Soft');
INSERT INTO compound (compound_id, compound_name) VALUES (2, 'Medium');
INSERT INTO compound (compound_id, compound_name) VALUES (3, 'Hard');
INSERT INTO compound (compound_id, compound_name) VALUES (4, 'Intermediate');
INSERT INTO compound (compound_id, compound_name) VALUES (5, 'Wet');
INSERT INTO compound (compound_id, compound_name) VALUES (6, 'Unknown');

INSERT INTO drs (drs_id, drs_state) VALUES (0, 'Off');
INSERT INTO drs (drs_id, drs_state) VALUES (1, 'Off');
INSERT INTO drs (drs_id, drs_state) VALUES (2, 'Unknowned');
INSERT INTO drs (drs_id, drs_state) VALUES (3, 'Unknowned');
INSERT INTO drs (drs_id, drs_state) VALUES (8, 'Detected');
INSERT INTO drs (drs_id, drs_state) VALUES (10, 'On');
INSERT INTO drs (drs_id, drs_state) VALUES (12, 'On');
INSERT INTO drs (drs_id, drs_state) VALUES (14, 'On');

INSERT INTO team (team_name, team_abbreviation, team_hex_color) VALUES ('Ferrari', 'FER', '#e80020');
INSERT INTO team (team_name, team_abbreviation, team_hex_color) VALUES ('McLaren', 'MCL', '#ff8000');
INSERT INTO team (team_name, team_abbreviation, team_hex_color) VALUES ('Red Bull Racing', 'RBR', '#0600ef');
INSERT INTO team (team_name, team_abbreviation, team_hex_color) VALUES ('Alpine', 'ALP', '#ff87bc');
INSERT INTO team (team_name, team_abbreviation, team_hex_color) VALUES ('Mercedes', 'MER', '#27f4d2');
INSERT INTO team (team_name, team_abbreviation, team_hex_color) VALUES ('Aston Martin', 'AMR', '#00665e');
INSERT INTO team (team_name, team_abbreviation, team_hex_color) VALUES ('Racing Bulls', 'RBS', '#fcd700');
INSERT INTO team (team_name, team_abbreviation, team_hex_color) VALUES ('Williams', 'WIL', '#00a0dd');
INSERT INTO team (team_name, team_abbreviation, team_hex_color) VALUES ('Sauber', 'SAU', '#00e700');
INSERT INTO team (team_name, team_abbreviation, team_hex_color) VALUES ('Haas', 'HAA', '#b6babd');

INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (1, 'VER', 'Max Verstappen', '#FF6600', 'NL');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (30, 'LAW', 'Liam Lawson', '#FFCC01', 'NZ');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (10, 'GAS', 'Pierre Gasly', '#08143b', 'FR');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (7, 'DOO', 'Jack Doohan', '#ff0063', 'AU');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (43, 'COL', 'Franco Colapinto', '#3576ae', 'AR');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (12, 'ANT', 'Kimi Antonelli', '#0ad95d', 'IT');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (63, 'RUS', 'George Russell', '#00a3e3', 'UK');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (14, 'ALO', 'Fernando Alonso', '#00a4e7', 'ES');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (18, 'STR', 'Lance Stroll', '#00665e', 'CA');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (16, 'LEC', 'Charles Leclerc', '#e1022d', 'MC');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (44, 'HAM', 'Lewis Hamilton', '#7a25f0', 'UK');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (22, 'TSU', 'Yuki Tsunoda', '#fd8b35', 'JP');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (6, 'HAD', 'Isack Hadjar', '#0023d1', 'FR');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (23, 'ALB', 'Alexander Albon', '#1d3728', 'TH');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (55, 'SAI', 'Carlos Sainz', '#da291c', 'ES');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (27, 'HUL', 'Nico Hulkenberg', '#181c25', 'DE');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (5, 'BOR', 'Gabriel Bortoleto', '#a5cd39', 'BR');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (31, 'OCO', 'Esteban Ocon', '#f10000', 'FR');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (87, 'BEA', 'Ollie Bearman', '#fff200', 'UK');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (4, 'NOR', 'Lando Norris', '#d2ff00', 'UK');
INSERT INTO driver (driver_number, driver_abbreviation, driver_name, driver_hex_color, country) VALUES (81, 'PIA', 'Oscar Piastri', '#0e1f66', 'AU');